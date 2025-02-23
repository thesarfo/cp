object Solution {
    def hasSameDigits(s: String): Boolean = {
        var str = s
        while (str.length > 2) {
            str = str.sliding(2).map(pair => ((pair(0) - '0' + pair(1) - '0') % 10).toString).mkString
        }
        str(0) == str(1)
    }
}
