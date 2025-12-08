import System.IO
import Data.List

data Cell = CharCell Char | IntCell Int deriving (Eq, Show)

main :: IO ()
main = do
    input <- readFile "day_7/input_day_7.txt"
    let grid = map (filter (/= '\r')) $ lines input
    let gridList = map (map (\c -> if c == '.' then IntCell 0 else CharCell c)) grid
    let start = findStart $ head gridList
    let updatedGrid = updateAt 1 start (IntCell 1) gridList
    let (finalGrid, count, lastRowSum) = simulate updatedGrid
    print count
    print lastRowSum

findStart :: [Cell] -> Int
findStart row = case findIndex (\c -> c == CharCell 'S') row of
    Just idx -> idx
    Nothing -> 0

updateAt :: Int -> Int -> Cell -> [[Cell]] -> [[Cell]]
updateAt row col val grid = 
    take row grid ++ 
    [updateRowAt col val (grid !! row)] ++ 
    drop (row + 1) grid

updateRowAt :: Int -> Cell -> [Cell] -> [Cell]
updateRowAt col val row = 
    take col row ++ [val] ++ drop (col + 1) row

simulate :: [[Cell]] -> ([[Cell]], Int, Int)
simulate grid = 
    let rows = length grid
        cols = if null grid then 0 else length (head grid)
        start = findStart $ head grid
        updatedGrid = updateAt 1 start (IntCell 1) grid
    in simulateRows updatedGrid rows cols 1 0

simulateRows :: [[Cell]] -> Int -> Int -> Int -> Int -> ([[Cell]], Int, Int)
simulateRows grid rows cols i count
    | i >= rows - 1 = let lastRow = grid !! (rows - 1)
                          lastRowSum = sum $ map (\x -> case x of
                                                          IntCell n -> n
                                                          _ -> 0) lastRow
                      in (grid, count, lastRowSum)
    | otherwise = 
        let (newGrid, newCount) = simulateRow grid rows cols i count
        in simulateRows newGrid rows cols (i + 1) newCount

simulateRow :: [[Cell]] -> Int -> Int -> Int -> Int -> ([[Cell]], Int)
simulateRow grid rows cols i count = 
    foldl (\(g, c) j -> processCell g rows cols i j c) (grid, count) [0..cols-1]

processCell :: [[Cell]] -> Int -> Int -> Int -> Int -> Int -> ([[Cell]], Int)
processCell grid rows cols i j count = 
    let cell = (grid !! i) !! j
    in case cell of
        IntCell val -> let nextCell = (grid !! (i + 1)) !! j
                       in case nextCell of
                           CharCell '^' -> let newGrid = if j == 0
                                                         then updateAt (i + 1) (j + 1) (addCell ((grid !! (i + 1)) !! (j + 1)) val) grid
                                                         else if j == cols - 1
                                                         then updateAt (i + 1) (j - 1) (addCell ((grid !! (i + 1)) !! (j - 1)) val) grid
                                                         else let g1 = updateAt (i + 1) (j + 1) (addCell ((grid !! (i + 1)) !! (j + 1)) val) grid
                                                              in updateAt (i + 1) (j - 1) (addCell ((grid !! (i + 1)) !! (j - 1)) val) g1
                                        in (newGrid, count + 1)
                           _ -> (updateAt (i + 1) j (addCell nextCell val) grid, count)
        _ -> (grid, count)

addCell :: Cell -> Int -> Cell
addCell (IntCell n) val = IntCell (n + val)
addCell (CharCell c) val = IntCell val

