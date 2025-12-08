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
processRange (low, high) = filter isMirrorNumber [low..high]

isMirrorNumber :: Int -> Bool
isMirrorNumber n = let num = show n
                       len = length num
                   in if len `mod` 2 == 1
                      then False
                      else let half = len `div` 2
                               part1 = take half num
                               part2 = drop half num
                           in part1 == part2

