object Solution {
  def maxDifference(s: String): Int = {
    val frequencyMap = s.groupBy(identity).view.mapValues(_.length).toMap  
    val (oddFrequencies, evenFrequencies) = frequencyMap.values.partition(_ % 2 == 1)
    oddFrequencies.max - evenFrequencies.min
  }
}

