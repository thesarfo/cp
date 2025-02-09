object Solution {
    def sortMatrix(g: Array[Array[Int]]): Array[Array[Int]] = {
        val n = g.length
        val res = Array.ofDim[Int](n, n)
        
        for {
            i <- 0 until n
            j <- 0 until n
        } res(i)(j) = g(i)(j)
        
        def getDia(sr: Int, sc: Int): IndexedSeq[(Int, Int, Int)] = {
            for {
                i <- 0 until n
                r = sr + i
                c = sc + i
                if r < n && c < n
            } yield (r, c, res(r)(c))
        }
        
        for (k <- 0 until n) {
            val dia = getDia(k, 0)
            val svg = dia.map(_._3).sorted.reverse
            
            for (((r, c, _), v) <- dia.zip(svg)) {
                res(r)(c) = v
            }
        }
        
        for (k <- 1 until n) {
            val dia = getDia(0, k)
            val svg = dia.map(_._3).sorted
            
            for (((r, c, _), v) <- dia.zip(svg)) {
                res(r)(c) = v
            }
        }
        
        res
    }
}
