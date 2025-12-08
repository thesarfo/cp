import System.IO
import Data.Char

main :: IO ()
main = do
    input <- readFile "day_1/input_day_1.txt"
    let lines = filter (not . null) $ map (filter (/= '\r')) $ lines input
    let result = processInput lines 50 0
    print result

processInput :: [String] -> Int -> Int -> Int
processInput [] _ count = count
processInput (item:rest) state count =
    let direction = head item
        num = read (tail item) :: Int
        newState = if direction == 'L'
                   then (state + 100 - (num `mod` 100)) `mod` 100
                   else (state + num) `mod` 100
        newCount = if newState == 0 then count + 1 else count
    in processInput rest newState newCount

