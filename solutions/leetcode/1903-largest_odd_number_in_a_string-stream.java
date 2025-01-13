class Solution {
    public String largestOddNumber(String num) {
        return IntStream.range(0, num.length())
                .filter(i -> (num.charAt(i) - '0') % 2 != 0)
                .mapToObj(i -> num.substring(0, i + 1))
                .reduce((first, second) -> second)
                .orElse("");
    }
}
