There are 5 main bitwise operators. AND, OR, XOR, SHIFT and NOT.

### AND operator
This operator goes with the below principles
- All true => true
- One false => false

`0` means false and `1` means true.

so if we write something as `x = 13 & 7`, what happens in the background is that 13 is converted into its binary format `1101` and 7 which is `111`. And then we do an `AND` with it.

Note that integers are stored in memory in 32 bits. So if the binary version of an integer is 4 numbers for instance, the computer makes up for the remaining 28 bits by pre-prending 28 0's to the binary number.

```
1, 1, 0, 1
0, 1, 1, 1

0, 1, 0, 1
```

Therefore the result of AND'ing these 2 numbers is `0101` which is `5` in decimal.


### OR operator
This operator goes with the below principles
- One true => true
- All false => false

So if we write `x = 13 | 7`

```
1, 1, 0, 1
0, 1, 1, 1

1, 1, 1, 1
```

Therefore, the result of OR'ing these 2 numbers is `1111` which is `15` in decimal.


### XOR Operator
This operator goes with the below principles
- No. of 1's are odd => 1
- No of 1's are even => 0

So if we write `x = 13 ^ 7`

```
1, 1, 0, 1
0, 1, 1, 1

1, 0, 1, 0

```

Therefore, the result of XOR'ing these 2 numbers is `1010` which is `10` in decimal

### SHIFT operator

There are 2 instances of this operator which is the right shift `>>` and the left shift `<<`

If we write `x = 13 >> 1` we are right shifting.

This means 

```
1, 1, 0, 1
```

The very last 1 at the end goes away, and the rest of the numbers get shifted to the right. So the numbe rnow becomes... `110`. Which is `6` in decimal. Similarly, when we say `13 >> 2` it means the last 2 numbers at the end 0 and 1 move away. Which now makes the binary become `11` which is `3` in decimal.

**There is a formula for calculating the above**: If we write `x >> k`, it can be represented as `x >> k = x / 2^k`. So right shifting 13 by 1 is simply 13/2 exponent 1.

**Left shift (<<)**

Left shift does the opposite of right shift.

If we write `x = 13 << 1`, all the bits are moved one position to the left, and a 0 is added at the end.

`1 1 0 1  →  1 1 0 1 0`


The new binary value is `11010`, which is `26` in decimal.

If we write `13 << 2`, the bits move left twice:

`1 1 0 1  →  1 1 0 1 0 0
`

Which becomes `52` in decimal.

So generally:

If we write `x << k`, it can be represented as:

`x × (2^k)`


### NOT operator (`~`)

The NOT operator is represented using the `~` symbol.

If we write something like `x = ~5`, what actually happens is:

1. The number is first converted to binary
2. **Every bit is flipped** (0 becomes 1, 1 becomes 0)
3. The result is interpreted using **2’s complement**, which is why the final value is usually negative


#### Step 1: Convert 5 to binary

Using 8 bits for simplicity:

```
5 = 00000101
```


#### Step 2: Flip all the bits

```
~5 = 11111010
```

At this point, the **leftmost bit is 1**, which means the number is **negative**.


#### Step 3: Understand 2’s complement

Computers store **negative numbers** using **2’s complement**.

To get the decimal value of a negative binary number stored in 2’s complement:

* Flip all the bits
* Add 1
* Apply a negative sign

So for `11111010`:

Flip the bits:

```
00000101
```

Add 1:

```
00000110
```

This equals `6` in decimal.

So the final value becomes:

```
~5 = -6
```

---

### Important thing to remember

Because of how 2’s complement works:

```
~x = -(x + 1)
```

So:

* `~5 = -6`
* `~0 = -1`
* `~(-1) = 0`