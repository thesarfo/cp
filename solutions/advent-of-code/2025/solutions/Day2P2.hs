import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_2/input_day_2.txt"
    let ranges = parseRanges input
    let result = sum $ concatMap processRange ranges
    print result

parseRanges :: String -> [(Int, Int)]
parseRanges input = map parseRange $ splitOn ',' $ head $ lines input
    where parseRange s = let [low, high] = map read $ splitOn '-' s
                         in (low, high)

splitOn :: Char -> String -> [String]
splitOn _ [] = []
splitOn c s = let (part, rest) = break (== c) s
              in part : case rest of
                          [] -> []
                          (_:xs) -> splitOn c xs

processRange :: (Int, Int) -> [Int]
processRange (low, high) = filter isRepeatingNumber [low..high]

isRepeatingNumber :: Int -> Bool
isRepeatingNumber n = let num = show n
                       in if length num == 1
                          then False
                          else checkRepeating num 1

checkRepeating :: String -> Int -> Bool
checkRepeating num j
    | j > length num `div` 2 = False
    | length num `mod` j /= 0 = checkRepeating num (j + 1)
    | otherwise = let parts = splitIntoParts num j
                      allSame = all (== head parts) parts
                  in if allSame then True else checkRepeating num (j + 1)

splitIntoParts :: String -> Int -> [String]
splitIntoParts [] _ = []
splitIntoParts s len = take len s : splitIntoParts (drop len s) len

