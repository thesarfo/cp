import System.IO
import Data.List

main :: IO ()
main = do
    input <- readFile "day_5/input_day_5.txt"
    let lines = filter (not . null) $ map (filter (/= '\r')) $ lines input
    let emptyIndex = findIndex null lines
    case emptyIndex of
        Just idx -> do
            let ranges = parseRanges $ take idx lines
            let sortedRanges = sortBy (\(a, _) (b, _) -> compare a b) ranges
            let merged = mergeRanges sortedRanges
            let result = sum $ map (\(low, high) -> high - low + 1) merged
            print result
        Nothing -> print 0

parseRanges :: [String] -> [(Int, Int)]
parseRanges = map parseRange
    where parseRange s = let [low, high] = map read $ splitOn '-' s
                         in (low, high)

splitOn :: Char -> String -> [String]
splitOn _ [] = []
splitOn c s = let (part, rest) = break (== c) s
              in part : case rest of
                          [] -> []
                          (_:xs) -> splitOn c xs

mergeRanges :: [(Int, Int)] -> [(Int, Int)]
mergeRanges [] = []
mergeRanges [x] = [x]
mergeRanges ((low1, high1):(low2, high2):rest)
    | high1 >= low2 = mergeRanges ((low1, max high1 high2):rest)
    | otherwise = (low1, high1) : mergeRanges ((low2, high2):rest)

