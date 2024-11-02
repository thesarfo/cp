import sys

input = sys.stdin.read

def main():
    data = input().split()
    t = int(data[0])
    index = 1
    results = []

    for _ in range(t):
        n = int(data[index])
        index += 1
        total = sum(int(data[index + i]) for i in range(2 * n))
        index += 2 * n

        min_on = total % 2
        max_on = min(total, 2 * n - total)
        results.append(f"{min_on} {max_on}")

    print("\n".join(results))

if __name__ == "__main__":
    main()