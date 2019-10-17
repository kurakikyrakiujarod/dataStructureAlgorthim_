def merge_sort(alist):
    n = len(alist)
    if n <= 1:
        return alist
    mid = n // 2
    left_li = merge_sort(alist[:mid])
    right_li = merge_sort(alist[mid:])
    left_pinter, right_pointer = 0, 0
    result = []
    while left_pinter < len(left_li) and right_pointer < len(right_li):
        if left_li[left_pinter] <= right_li[right_pointer]:
            result.append(left_li[left_pinter])
            left_pinter += 1
        else:
            result.append(right_li[right_pointer])
            right_pointer += 1
    result.extend(left_li[left_pinter:])
    result.extend(right_li[right_pointer:])
    return result


if __name__ == '__main__':
    alist = [9, 8, 10, 11, 0, 1, 2, 10, 11, 12, 3, 5, 7]
    print(merge_sort(alist))
