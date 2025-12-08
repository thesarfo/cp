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
        hundreds = num `div` 100
        remainder = num `mod` 100
        (newState, wrapCount) = if direction == 'L'
                                then let newS = (state - remainder + 100) `mod` 100
                                         wrap = if state - remainder < 0 && state /= 0 then 1 else 0
                                     in (newS, wrap)
                                else let newS = (state + remainder) `mod` 100
                                         wrap = if state + remainder > 100 then 1 else 0
                                     in (newS, wrap)
        newCount = count + hundreds + wrapCount + (if newState == 0 then 1 else 0)
    in processInput rest newState newCount

