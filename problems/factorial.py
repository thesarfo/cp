def factorial(n):
    if n == 0:
        return 1
    else:
        f = n * factorial(n - 1)
        print(f)  # print intermediate results (optional)
        return f

print(factorial(1))