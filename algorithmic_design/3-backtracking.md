## Backtracking

It is a form of recursion that is particularly useful for problems like traversing tree structures, where we are presented with a number of options at each node, from which we must choose one. Subsequently we are presented with a different set of options, and depending on the series of choices made either a goal state or a dead end is reached. If it is the latter, we must backtrack to a previous node and traverse a different branch. Backtracking is a divide and conquer method for exhaustive search. Importantly, backtracking prunes branches that cannot give a result.

Take the below example, where we have used a recursive approach to generating all the possible permutations of a given string, s, of a given length n.

```python
def bitStr(n, s):
    if n == 1: return s
    return [ digit + bits for digit in bitStr(1, s) for bits in bitStr(n - 1, s)]
    
print(bitStr(3, 'abs'))
```
