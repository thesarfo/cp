def descending_order(num):
    sorted_str = ''.join(sorted(str(num), reverse=True))
    return int(sorted_str)