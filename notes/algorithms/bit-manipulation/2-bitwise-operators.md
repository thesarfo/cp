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