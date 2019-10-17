def binary_search(alist, value):
    n = len(alist)
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if alist[mid] == value:
            return mid
        elif alist[mid] > value:
            end = mid - 1
        else:
            start = mid + 1
    return -1


def binary_search2(alist, value):
    return _binary_search2(alist, value, 0, len(alist) - 1)


def _binary_search2(alist, value, start, end):
    if start > end:
        return -1
    mid = (start + end) // 2
    if alist[mid] == value:
        return mid
    elif alist[mid] > value:
        return _binary_search2(alist, value, start, mid)
    else:
        return _binary_search2(alist, value, mid + 1, end)


if __name__ == '__main__':
    alist = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    print(binary_search(alist, 6))
    print(binary_search2(alist, 9))
