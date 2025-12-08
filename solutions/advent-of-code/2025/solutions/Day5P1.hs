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
            let ids = map read $ drop (idx + 1) lines :: [Int]
            let result = length $ filter (isInRange ranges) ids
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

isInRange :: [(Int, Int)] -> Int -> Bool
isInRange [] _ = False
isInRange ((low, high):rest) id = 
    if low <= id && id <= high 
    then True 
    else isInRange rest id

