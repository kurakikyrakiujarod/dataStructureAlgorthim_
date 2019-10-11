def quick_sort(alist):
    _quick_sort(alist, 0, len(alist) - 1)


def _quick_sort(alist, start, end):
    if start >= end:
        return
    pivot = alist[start]
    low = start
    high = end
    while low < high:
        while low < high and alist[high] >= pivot:
            high -= 1
        alist[low] = alist[high]
        while low < high and alist[low] < pivot:
            low += 1
        alist[high] = alist[low]
    alist[low] = pivot
    _quick_sort(alist, start, low - 1)
    _quick_sort(alist, low + 1, end)


if __name__ == '__main__':
    alist = [11, 12, 1, 2, 8, 9, 4, 5, 6, 99, 89]
    quick_sort(alist)
    print(alist)
