def select_sort(alist):
    n = len(alist)
    for i in range(n - 1):
        min_index = i
        for j in range(i + 1, n):
            if alist[j] < alist[min_index]:
                min_index = j
        if min_index != i:
            alist[min_index], alist[i] = alist[i], alist[min_index]


if __name__ == '__main__':
    alist = [11, 12, 3, 0, 4, 5, 9, 8, 7]
    select_sort(alist)
    print(alist)
