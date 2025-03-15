class Spreadsheet(_rows: Int) {
  private val grid = Array.ofDim[Int](_rows, 26)
  
  def setCell(cell: String, value: Int): Unit = {
    val coordinates = parseCellReference(cell)
    grid(coordinates._1)(coordinates._2) = value
  }
  
  def resetCell(cell: String): Unit = {
    val coordinates = parseCellReference(cell)
    grid(coordinates._1)(coordinates._2) = 0
  }
  
  def getValue(formula: String): Int = {
    if (formula.startsWith("=")) {
      val parts = formula.substring(1).split("\\+")
      val x = parseOperand(parts(0))
      val y = parseOperand(parts(1))
      x + y
    } else 0
  }
  
  private def parseOperand(operand: String): Int = {
    if (operand.nonEmpty && operand(0).isLetter) {
      val coordinates = parseCellReference(operand)
      grid(coordinates._1)(coordinates._2)
    } else {
      operand.toInt
    }
  }
  
  private def parseCellReference(cell: String): (Int, Int) = {
    val col = cell(0) - 'A'
    val row = cell.substring(1).toInt - 1
    (row, col)
  }
}