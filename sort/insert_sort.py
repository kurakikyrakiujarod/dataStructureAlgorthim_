def insert_sort(alist):
    n = len(alist)
    for i in range(1, n):
        j = i
        while j > 0:
            if alist[j] < alist[j - 1]:
                alist[j], alist[j - 1] = alist[j - 1], alist[j]
            else:
                break
            j -= 1


if __name__ == '__main__':
    alist = [11, 1, 2, 3, 21, 22, 23, 8, 9, 0]
    insert_sort(alist)
    print(alist)
