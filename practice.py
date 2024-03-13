def solution(numbers):
    fin = []
    for i in range(1,len(numbers)-1):
        if (numbers[i-1] < numbers[i] > numbers[i+1]) or (numbers[i-1] > numbers[i] < numbers[i+1]):
            fin.append(1)
        else:
            fin.append(0)
    return fin

print(solution([1, 2, 1, 3, 4]))