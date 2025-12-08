import System.IO
import Data.List
import Data.Char

main :: IO ()
main = do
    input <- readFile "day_6/input_day_6.txt"
    let lines = filter (not . null) $ map (filter (/= '\r')) $ lines input
    let width = maximum $ map length lines
    let rows = map (`padRight` width) lines
    let height = length rows
    let sep = [all (\r -> (rows !! r) !! c == ' ') [0..height-1] | c <- [0..width-1]]
    let blocks = findBlocks sep 0 width
    let result = sum $ map (processBlock rows height) blocks
    print result

padRight :: String -> Int -> String
padRight s len = s ++ replicate (len - length s) ' '

findBlocks :: [Bool] -> Int -> Int -> [(Int, Int)]
findBlocks [] _ _ = []
findBlocks sep c width
    | c >= width = []
    | sep !! c = findBlocks sep (c + 1) width
    | otherwise = let start = c
                      end = findBlockEnd sep c width
                  in (start, end) : findBlocks sep (end + 1) width

findBlockEnd :: [Bool] -> Int -> Int -> Int
findBlockEnd sep c width
    | c >= width = width - 1
    | sep !! c = c - 1
    | otherwise = findBlockEnd sep (c + 1) width

processBlock :: [String] -> Int -> (Int, Int) -> Int
processBlock rows height (start, end) = 
    let op = trim $ take (end - start + 1) $ last rows
        numbers = extractNumbers rows height start end
        value = if op == "+" then sum numbers else product numbers
    in value

trim :: String -> String
trim = reverse . dropWhile (== ' ') . reverse . dropWhile (== ' ')

extractNumbers :: [String] -> Int -> Int -> Int -> [Int]
extractNumbers rows height start end = 
    filter (> 0) $ map (extractColumnNumber rows height) [start..end]

extractColumnNumber :: [String] -> Int -> Int -> Int
extractColumnNumber rows height col = 
    let digits = filter isDigit [rows !! row !! col | row <- [0..height-2]]
    in if null digits then 0 else read digits

