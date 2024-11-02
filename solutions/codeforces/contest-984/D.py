def count_occurrences(layer, target):
    ext_layer = layer + layer[:len(target)-1]
    return sum(1 for i in range(len(ext_layer) - len(target) + 1) if ext_layer[i:i + len(target)] == target)

def extract_layers(n, m, carpet):
    layers = []
    sr, er = 0, n - 1
    sc, ec = 0, m - 1
    
    while sr <= er and sc <= ec:
        cl = []
        
        cl.extend(carpet[sr][sc:ec + 1])
        
        for i in range(sr + 1, er):
            cl.append(carpet[i][ec])
        
        if sr < er:
            cl.extend(carpet[er][sc:ec + 1][::-1])
        
        if sc < ec:
            for i in range(er - 1, sr, -1):
                cl.append(carpet[i][sc])
        
        layers.append(''.join(cl))
        
        sr += 1
        er -= 1
        sc += 1
        ec -= 1
    
    return layers

def count_1543(t, cases):
    target = "1543"
    results = []
    
    for i in range(t):
        n, m = cases[i][0]
        carpet = cases[i][1]
        
        layers = extract_layers(n, m, carpet)
        total = 0
        
        for l in layers:
            total += count_occurrences(l, target)
        
        results.append(total)
    
    return results

t = int(input())
cases = []
for _ in range(t):
    n, m = map(int, input().split())
    carpet = [input().strip() for _ in range(n)]
    cases.append(((n, m), carpet))

results = count_1543(t, cases)

for result in results:
    print(result)