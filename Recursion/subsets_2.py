def subsets2(nums):
    res = [[]]
    for num in nums:
        res += [i + [num] for i in res if i + [num] not in res]
    return res


def subsets_recursive2(nums):
    lst = []
    result = []
    nums.sort()
    # print(nums)
    subsets2_recursive_helper(result, lst, nums, 0)
    return result


def subsets2_recursive_helper(result, lst, nums, pos):
    result.append(lst[:])
    for i in range(pos, len(nums)):
        if i != pos and nums[i] == nums[i - 1]:
            continue

        lst.append(nums[i])
        subsets2_recursive_helper(result, lst, nums, i + 1)
        lst.pop()


if __name__ == '__main__':
    nums = [1, 2, 2]
    print(subsets2(nums))
    print(subsets_recursive2(nums))
