def perm(result, nums):
    if len(nums) == 0:
        print(result)

    for i in range(len(nums)):
        perm(result + str(nums[i]), nums[0:i] + nums[i + 1:])  #


if __name__ == '__main__':
    nums = [1, 2, 3]
    perm('', nums)
