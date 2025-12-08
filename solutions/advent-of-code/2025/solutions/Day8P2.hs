import System.IO
import Data.List
import Data.Array

main :: IO ()
main = do
    input <- readFile "day_8/input_day_8.txt"
    let coordinates = map parseCoordinate $ lines input
    let n = length coordinates
    let edges = sortBy (\(a, _, _) (b, _, _) -> compare a b) 
                 [(distance (coordinates !! i) (coordinates !! j), i, j) 
                  | i <- [0..n-1], j <- [i+1..n-1]]
    let uf = initializeUF n
    let (finalUF, u, v) = processEdges uf edges coordinates
    let sizes = getSizes finalUF n
    let result = (fst u) * (fst v)
    print result

parseCoordinate :: String -> (Int, Int, Int)
parseCoordinate s = let [x, y, z] = map read $ splitOn ',' s
                    in (x, y, z)

splitOn :: Char -> String -> [String]
splitOn _ [] = []
splitOn c s = let (part, rest) = break (== c) s
              in part : case rest of
                          [] -> []
                          (_:xs) -> splitOn c xs

distance :: (Int, Int, Int) -> (Int, Int, Int) -> Double
distance (x1, y1, z1) (x2, y2, z2) = 
    sqrt $ fromIntegral $ (x1 - x2)^2 + (y1 - y2)^2 + (z1 - z2)^2

data UnionFind = UF { parent :: Array Int Int, size :: Array Int Int }

initializeUF :: Int -> UnionFind
initializeUF n = UF (listArray (0, n-1) [0..n-1]) (listArray (0, n-1) (replicate n 1))

find' :: UnionFind -> Int -> Int
find' uf x = 
    let p = parent uf ! x
    in if p == x then x else find' uf p

union :: UnionFind -> Int -> Int -> UnionFind
union uf x y = 
    let rx = find' uf x
        ry = find' uf y
    in if rx == ry 
       then uf
       else let sx = size uf ! rx
                sy = size uf ! ry
            in if sx < sy
               then updateParent uf ry rx (sx + sy)
               else updateParent uf rx ry (sx + sy)

updateParent :: UnionFind -> Int -> Int -> Int -> UnionFind
updateParent uf oldRoot newRoot newSize = 
    let newParent = parent uf // [(oldRoot, newRoot)]
        newSizeArr = size uf // [(newRoot, newSize)]
    in UF newParent newSizeArr

processEdges :: UnionFind -> [(Double, Int, Int)] -> [(Int, Int, Int)] -> (UnionFind, (Int, Int, Int), (Int, Int, Int))
processEdges uf [] _ = error "No edges found"
processEdges uf ((_, i, j):rest) coordinates = 
    let newUF = union uf i j
        sizes = getSizes newUF (length coordinates)
    in if length sizes == 1
       then (newUF, coordinates !! i, coordinates !! j)
       else processEdges newUF rest coordinates

getSizes :: UnionFind -> Int -> [Int]
getSizes uf n = 
    let roots = map (find' uf) [0..n-1]
        uniqueRoots = nub roots
        sizes = map (\r -> size uf ! r) uniqueRoots
    in reverse $ sort sizes

