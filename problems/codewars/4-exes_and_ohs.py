def xo(s):
    countx = 0
    county = 0
    
    s = s.lower()
    
    for i in s:
        if i == "x":
            countx += 1
        elif i == "o":
            county += 1
    
    return countx == county
