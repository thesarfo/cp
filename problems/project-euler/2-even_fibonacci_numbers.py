def fibonacci(n):
    fib_sequence = [0, 1]  
    
    while len(fib_sequence) < n:
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])
    
    even_sum = sum(x for x in fib_sequence if x % 2 == 0)

    return even_sum

print(fibonacci(10))