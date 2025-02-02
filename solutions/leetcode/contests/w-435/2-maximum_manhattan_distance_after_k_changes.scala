object Solution {
    def maxDistance(s: String, k: Int): Int = {
        var u = 0; var d = 0; var r = 0; var l = 0; var mx = 0
        for (i <- s.indices) {
            s(i) match {
                case 'N' => u += 1
                case 'S' => d += 1
                case 'E' => r += 1
                case 'W' => l += 1
            }
            val vs = Math.abs(u - d)
            val hs = Math.abs(r - l)
            val bd = vs + hs
            val im = Math.min(u, d) + Math.min(r, l)
            val mp = bd + Math.min(k, im) * 2
            mx = Math.max(mx, Math.min(i + 1, mp))
        }
        mx
    }
}©leetcode