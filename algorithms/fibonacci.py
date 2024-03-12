def fibonacci(n):
    fib_sequence = [0, 1]  # Initialize the Fibonacci sequence with the first two terms
    
    # Generate Fibonacci sequence up to the nth term
    while len(fib_sequence) < n:
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])  # Add the last two terms to get the next term
        
    return fib_sequence

# Example: Calculate Fibonacci sequence up to 10 terms
n = 10
fib_sequence = fibonacci(n)
print("Fibonacci sequence up to", n, "terms:", fib_sequence)