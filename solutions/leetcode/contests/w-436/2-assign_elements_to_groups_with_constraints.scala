object Solution {
    def assignElements(g: Array[Int], e: Array[Int]): Array[Int] = {
        val size = g.length
        val ans = new Array[Int](size)
        
        val mp = e.zipWithIndex.foldLeft(Map[Int, Int]()) { 
            case (m, (v, i)) => if (!m.contains(v)) m + (v -> i) else m 
        }
        
        for (i <- 0 until size) {
            val cur = g(i)
            var min = Int.MaxValue
            
            for (j <- 1 to math.sqrt(cur).toInt) {
                if (cur % j == 0) {
                    if (mp.contains(j)) {
                        min = min.min(mp(j))
                    }
                    val cmp = cur / j
                    if (cmp != j && mp.contains(cmp)) {
                        min = min.min(mp(cmp))
                    }
                }
            }
            
            ans(i) = if (min != Int.MaxValue) min else -1
        }
        ans
    }
}
