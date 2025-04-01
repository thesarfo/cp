object Solution {
  def minEatingSpeed(piles: Array[Int], h: Int): Int = {
    val max = piles.max
    var low = 1
    var high = max

    while (low < high) {
      val mid = low + (high - low) / 2
      val totalH = calculateTotalHours(piles, mid)

      if (totalH <= h) {
        high = mid
      } else {
        low = mid + 1
      }
    }
    low
  }

  def calculateTotalHours(piles: Array[Int], hourly: Int): Int = {
    piles.map(pile => Math.ceil(pile.toDouble / hourly).toInt).sum
  }
}

