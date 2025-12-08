import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_4/input_day_4.txt"
    let grid = map (filter (/= '\r')) $ lines input
    let result = countValidPositions grid
    print result

directions :: [(Int, Int)]
directions = [(-1, -1), (-1, 0), (-1, 1),
              ( 0, -1),          ( 0, 1),
              ( 1, -1), ( 1, 0), ( 1, 1)]

countValidPositions :: [String] -> Int
countValidPositions grid = 
    let rows = length grid
        cols = if null grid then 0 else length (head grid)
    in sum [if isValid grid rows cols i j then 1 else 0 
            | i <- [0..rows-1], j <- [0..cols-1]]

isValid :: [String] -> Int -> Int -> Int -> Int -> Bool
isValid grid rows cols i j = 
    if grid !! i !! j == '.' 
    then False
    else let neighbors = [grid !! ni !! nj | (di, dj) <- directions,
                                             let ni = i + di,
                                             let nj = j + dj,
                                             ni >= 0 && ni < rows && nj >= 0 && nj < cols]
             atCount = length $ filter (== '@') neighbors
         in atCount < 4

