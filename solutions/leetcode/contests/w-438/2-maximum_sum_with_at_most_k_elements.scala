object Solution {
    def maxSum(grid: Array[Array[Int]], limits: Array[Int], k: Int): Long = {
        val values = grid.zip(limits).flatMap { case (row, limit) =>
            row.sorted(Ordering[Int].reverse).take(limit)
        }
        values.sorted(Ordering[Int].reverse).take(k).map(_.toLong).sum
    }
}
