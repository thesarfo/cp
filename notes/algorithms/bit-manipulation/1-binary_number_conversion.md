## Decimal to Binary Conversion

[Leetcode 1017](https://leetcode.com/problems/convert-to-base-2/)

To convert a decimal number to binary, we repeatedly divide the number by 2 and collect the remainders. The binary representation is the remainders read from bottom to top.

**Algorithm:**
1. Divide the number by 2
2. Write down the remainder (0 or 1)
3. Continue with the quotient
4. Repeat until the quotient becomes 0
5. Read the remainders from bottom to top

**Example 1: Convert 13 to binary**

```
13 ÷ 2 = 6 remainder 1  ←
6 ÷ 2 = 3 remainder 0   ←
3 ÷ 2 = 1 remainder 1   ←
1 ÷ 2 = 0 remainder 1   ←
                        ↑
Read from bottom to top: 1101

Therefore, 13₁₀ = 1101₂
```

**Example 2: Convert 25 to binary**

```
25 ÷ 2 = 12 remainder 1 ←
12 ÷ 2 = 6 remainder 0  ←
6 ÷ 2 = 3 remainder 0   ←
3 ÷ 2 = 1 remainder 1   ←
1 ÷ 2 = 0 remainder 1   ←
                        ↑
Read from bottom to top: 11001

Therefore, 25₁₀ = 11001₂
```

---

## Binary to Decimal Conversion

To convert a binary number to decimal, we multiply each digit by its corresponding power of 2 and sum the results. Start from the rightmost digit (position 0) and move left.

**Algorithm:**
1. Start from the rightmost digit (position 0)
2. Multiply each digit by 2 raised to its position
3. Sum all the results

**Example 1: Convert 1101 to decimal**

```
Position:  3  2  1  0
Binary:    1  1  0  1

Calculation:
1 × 2³ = 1 × 8 = 8
1 × 2² = 1 × 4 = 4
0 × 2¹ = 0 × 2 = 0
1 × 2⁰ = 1 × 1 = 1
                ────
                 13

Therefore, 1101₂ = 13₁₀
```

**Example 2: Convert 10101 to decimal**

```
Position:  4  3  2  1  0
Binary:    1  0  1  0  1

Calculation:
1 × 2⁴ = 1 × 16 = 16
0 × 2³ = 0 × 8  =  0
1 × 2² = 1 × 4  =  4
0 × 2¹ = 0 × 2  =  0
1 × 2⁰ = 1 × 1  =  1
                  ────
                   21

Therefore, 10101₂ = 21₁₀
```

### Code Implementation

#### Decimal to Binary

```java
String convertToBinary(int num){
    if(num == 0) return "0";
    
    StringBuilder res = new StringBuilder();
    while(num > 0){
        if(num % 2 == 1){
            res.append('1');
        } else {
            res.append('0');
        }
        num = num / 2;
    }
    
    // Reverse because we read remainders from bottom to top
    return res.reverse().toString();
}
```


**Example usage:**
- `convertToBinary(13)` returns `"1101"`
- `convertToBinary(25)` returns `"11001"`

---

#### Binary to Decimal

```java
int convertToDecimal(String binary){
    int result = 0;
    int power = 0;
    
    // Start from rightmost digit (position 0)
    for(int i = binary.length() - 1; i >= 0; i--){
        if(binary.charAt(i) == '1'){
            result += Math.pow(2, power);
        }
        power++;
    }
    
    return result;
}
```

**Example usage:**
- `convertToDecimal("1101")` returns `13`
- `convertToDecimal("10101")` returns `21`