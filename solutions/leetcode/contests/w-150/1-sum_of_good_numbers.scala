object Solution {
    def sumOfGoodNumbers(arr: Array[Int], gap: Int): Int = {
        var total = 0
        val length = arr.length

        for (i <- arr.indices) {
            var valid = true

            if (i - gap >= 0 && arr(i) <= arr(i - gap)) valid = false
            if (i + gap < length && arr(i) <= arr(i + gap)) valid = false

            if (valid) total += arr(i)
        }

        total
    }
}

