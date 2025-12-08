import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_4/input_day_4.txt"
    let grid = map (filter (/= '\r')) $ lines input
    let result = simulateIterations grid (length grid)
    print result

directions :: [(Int, Int)]
directions = [(-1, -1), (-1, 0), (-1, 1),
              ( 0, -1),          ( 0, 1),
              ( 1, -1), ( 1, 0), ( 1, 1)]

simulateIterations :: [String] -> Int -> Int
simulateIterations grid iterations = 
    let rows = length grid
        cols = if null grid then 0 else length (head grid)
    in simulateIterations' grid rows cols iterations 0

simulateIterations' :: [String] -> Int -> Int -> Int -> Int -> Int
simulateIterations' grid _ _ 0 count = count
simulateIterations' grid rows cols remaining count = 
    let removed = sum [if shouldRemove grid rows cols i j then 1 else 0 
                       | i <- [0..rows-1], j <- [0..cols-1]]
        newGrid = updateGrid grid rows cols
    in simulateIterations' newGrid rows cols (remaining - 1) (count + removed)

updateGrid :: [String] -> Int -> Int -> [String]
updateGrid grid rows cols = 
    map (\i -> map (\j -> if shouldRemove grid rows cols i j then '.' else grid !! i !! j) [0..cols-1]) [0..rows-1]

shouldRemove :: [String] -> Int -> Int -> Int -> Int -> Bool
shouldRemove grid rows cols i j = 
    if grid !! i !! j == '.' 
    then False
    else let neighbors = [grid !! ni !! nj | (di, dj) <- directions,
                                             let ni = i + di,
                                             let nj = j + dj,
                                             ni >= 0 && ni < rows && nj >= 0 && nj < cols]
             atCount = length $ filter (== '@') neighbors
         in atCount < 4

