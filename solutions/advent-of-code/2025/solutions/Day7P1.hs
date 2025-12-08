import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_7/input_day_7.txt"
    let grid = map (filter (/= '\r')) $ lines input
    let gridList = map (map (:[])) grid
    let start = findStart $ head gridList
    let updatedGrid = updateAt 1 start '|' gridList
    let (finalGrid, count) = simulate updatedGrid
    print count

findStart :: [[Char]] -> Int
findStart row = case elemIndex 'S' (map head row) of
    Just idx -> idx
    Nothing -> 0

updateAt :: Int -> Int -> Char -> [[[Char]]] -> [[[Char]]]
updateAt row col val grid = 
    take row grid ++ 
    [updateRowAt col val (grid !! row)] ++ 
    drop (row + 1) grid

updateRowAt :: Int -> Char -> [[Char]] -> [[Char]]
updateRowAt col val row = 
    take col row ++ [[val]] ++ drop (col + 1) row

simulate :: [[[Char]]] -> ([[[Char]]], Int)
simulate grid = 
    let rows = length grid
        cols = if null grid then 0 else length (head grid)
    in simulateRows grid rows cols 1 0

simulateRows :: [[[Char]]] -> Int -> Int -> Int -> Int -> ([[[Char]]], Int)
simulateRows grid rows cols i count
    | i >= rows - 1 = (grid, count)
    | otherwise = 
        let (newGrid, newCount) = simulateRow grid rows cols i count
        in simulateRows newGrid rows cols (i + 1) newCount

simulateRow :: [[[Char]]] -> Int -> Int -> Int -> Int -> ([[[Char]]], Int)
simulateRow grid rows cols i count = 
    foldl (\(g, c) j -> processCell g rows cols i j c) (grid, count) [0..cols-1]

processCell :: [[[Char]]] -> Int -> Int -> Int -> Int -> Int -> ([[[Char]]], Int)
processCell grid rows cols i j count = 
    let cell = head $ (grid !! i) !! j
    in if cell /= '|'
       then (grid, count)
       else let nextCell = head $ (grid !! (i + 1)) !! j
            in if nextCell /= '^'
               then (updateAt (i + 1) j '|' grid, count)
               else let newGrid = if j == 0
                                  then updateAt (i + 1) (j + 1) '|' grid
                                  else if j == cols - 1
                                  then updateAt (i + 1) (j - 1) '|' grid
                                  else let g1 = updateAt (i + 1) (j + 1) '|' grid
                                       in updateAt (i + 1) (j - 1) '|' g1
                    in (newGrid, count + 1)

