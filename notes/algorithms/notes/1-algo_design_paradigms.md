There are three broad approaches to algo design.

1. Divide and Conquer
2. Greedy Algorithms
3. Dynamic programming

### Divide and Conquer
This involves breaking a problem into smaller sub problems, and then in some way combining the results to obtain a global solution. This is a very common and natural problem solving technique, and is, arguably, the most commonly used approach to algorithm design.

### Greedy Algorithms
They involve optimization and combinatorial problems, the classic example is applying it to the traveling salesperson problem, where a greedy approach always chooses the closest destination first. This shortest path strategy involves finding the
best solution to a local problem in the hope that this will lead to a global solution.

### Dynamic Programming 
This approach is useful when our sub problems overlap. This is different from divide and conquer. Rather than break our problem into independent sub problems, with dynamic programming, intermediate results are cached and can be used in subsequent operations. Like divide and conquer it uses recursion; however, dynamic programming allows us to compare results at different stages. This can have a performance advantage over divide and conquer for some problems because it is often quicker to retrieve a previously calculated result from memory rather than having to recalculate it