def solution(n):
    final = []
    for i in range(n):
        if i % 3 == 0 or i % 5 == 0:
            final.append(i)
    return final

print(solution(1000))