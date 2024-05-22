Recursion is particularly useful for divide and conquer problems; however, it can be difficult to understand exactly what is happening, since each recursive call is itself spinning off other recursive calls. At the core of a recursive function are two types of cases: base cases, which tell the recursion when to terminate, and recursive cases that call the function they are in. A simple problem that naturally lends itself to a recursive solution is calculating factorials. The recursive factorial algorithm defines two cases: the base case when n is zero, and the recursive case when n is greater than zero. A typical implementation is the following

```python
def factorial(n):
    #test for a base case
    if n == 0:
        return 1
    else:
        # make a calculation and a recursive call
        f = n * factorial(n - 1)
        print(f) #print intermediate results (optional)
        return (f)
```