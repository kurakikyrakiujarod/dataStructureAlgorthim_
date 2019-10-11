def bubble_sort(alist):
    n = len(alist)
    for i in range(n - 1):
        count = 0
        for j in range(n - 1 - i):
            if alist[j] > alist[j + 1]:
                alist[j], alist[j + 1] = alist[j + 1], alist[j]
                count += 1
        if count == 0:
            break


def bubble_sort2(alist):
    for i in range(len(alist) - 1, 0, -1):
        for j in range(i):
            if alist[j + 1] > alist[j]:
                alist[j], alist[j + 1] = alist[j + 1], alist[j]


if __name__ == '__main__':
    alist = [0, 12, 9, 3, 4, 3, 99, 1, 2, 3, 4]
    bubble_sort(alist)
    print(alist)
    bubble_sort2(alist)
    print(alist)
