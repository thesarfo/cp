class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        Long gcd = findGCD(A, B);
        
        Long lcm = (A * B) / gcd;
        
        return new Long[]{lcm, gcd};
    }

    static Long findGCD(Long A, Long B) {
        while (B != 0) {
            Long temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}