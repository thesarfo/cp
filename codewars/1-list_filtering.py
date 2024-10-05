def filter_list(l):
    'return a new list with the strings filtered out'
    new = []
    for char in l:
        if isinstance(char, int):
            new.append(char)
    return new