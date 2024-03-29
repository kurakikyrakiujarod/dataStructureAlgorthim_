def subsets(nums):
    result = [[]]
    for num in nums:
        for element in result[:]:
            x = element[:]
            x.append(num)
            result.append(x)

    return result


def subsets_2(nums):
    res = [[]]
    for num in nums:
        res += [i + [num] for i in res]
    return res


def subsets_recursive(nums):
    lst = []
    result = []
    subsets_recursive_helper(result, lst, nums, 0)
    return result


def subsets_recursive_helper(result, lst, nums, pos):
    result.append(lst[:])
    for i in range(pos, len(nums)):
        lst.append(nums[i])
        subsets_recursive_helper(result, lst, nums, i + 1)
        lst.pop()


if __name__ == '__main__':
    nums = [1, 2, 3]
    print(subsets(nums))
    # print(subsets_recursive(nums))
