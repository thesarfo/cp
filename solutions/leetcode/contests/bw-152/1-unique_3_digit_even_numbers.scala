object Solution {
  def totalNumbers(digits: Array[Int]): Int = {
    val freq = Array.fill(10)(0)
    digits.foreach(d => freq(d) += 1)
    
    var count = 0
    
    for (i <- 1 to 9 if freq(i) > 0) {
      freq(i) -= 1
      
      for (j <- 0 to 9 if freq(j) > 0) {
        freq(j) -= 1
        
        for (k <- 0 to 8 by 2 if freq(k) > 0) {
          count += 1
        }
        
        freq(j) += 1
      }
      
      freq(i) += 1
    }
    
    count
  }
}