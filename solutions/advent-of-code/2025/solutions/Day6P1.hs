import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_6/input_day_6.txt"
    let lines = reverse $ filter (not . null) $ map (filter (/= '\r')) $ lines input
    let equations = map (filter (/= "") . words) lines
    let operations = head equations
    let result = foldl (processRow operations) (map read (equations !! 1) :: [Int]) (drop 2 equations)
    print $ sum result

processRow :: [String] -> [Int] -> [String] -> [Int]
processRow operations result numbers = 
    zipWith processOp operations result (map read numbers :: [Int])

processOp :: String -> Int -> Int -> Int
processOp "+" a b = a + b
processOp "*" a b = a * b
processOp _ a _ = a

