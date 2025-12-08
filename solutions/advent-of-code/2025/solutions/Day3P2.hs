import System.IO
import Data.Char

main :: IO ()
main = do
    input <- readFile "day_3/input_day_3.txt"
    let banks = map (map digitToInt) $ lines input
    let result = sum $ map processBank banks
    print result

processBank :: [Int] -> Int
processBank bank = let result = selectDigits bank 0 12
                    in foldl (\acc x -> acc * 10 + x) 0 result

selectDigits :: [Int] -> Int -> Int -> [Int]
selectDigits _ _ 0 = []
selectDigits bank start remaining = 
    let ranges = length bank - 12 + remaining
        (maxVal, index) = findMax bank start ranges
    in maxVal : selectDigits bank (index + 1) (remaining - 1)

findMax :: [Int] -> Int -> Int -> (Int, Int)
findMax bank start end = let indexed = zip [start..end] (drop start $ take (end + 1) bank)
                         in maximumBy (\(_, a) (_, b) -> compare a b) indexed

maximumBy :: (a -> a -> Ordering) -> [(Int, a)] -> (a, Int)
maximumBy _ [(idx, x)] = (x, idx)
maximumBy cmp ((idx, x):xs) = let (maxVal, maxIdx) = maximumBy cmp xs
                               in case cmp x maxVal of
                                    GT -> (x, idx)
                                    _ -> (maxVal, maxIdx)

