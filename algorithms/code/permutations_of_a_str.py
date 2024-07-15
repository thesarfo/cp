def bitStr(n, s):
    if n == 1:
        return s
    return [digit + bits for digit in bitStr(1, s) for bits in bitStr(n - 1, s)]


print(bitStr(3, 'abc'))


# The same algorithm implemented with nested loops
def bitStr(n, s):
    if n == 1:
        return list(s)

    result = []
    for digit in bitStr(1, s):
        for bits in bitStr(n - 1, s):
            result.append(digit + bits)

    return result
