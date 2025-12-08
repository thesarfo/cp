import System.IO
import Data.Char

main :: IO ()
main = do
    input <- readFile "day_3/input_day_3.txt"
    let banks = map (map digitToInt) $ lines input
    let result = sum $ map maxPairProduct banks
    print result

maxPairProduct :: [Int] -> Int
maxPairProduct bank = maximum [bank !! i * 10 + bank !! j | i <- [0..length bank - 1], j <- [i+1..length bank - 1]]

