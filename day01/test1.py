import math


def goldbach(n):
    primes_dict = {n: True for n in range(2, n + 1)}
    for i in range(2, n + 1):
        for j in range(2, int(math.sqrt(i) + 1)):
            if i % j == 0:
                primes_dict[i] = False

    rst = [1] + [k for k in primes_dict if primes_dict[k]]
    left = 0
    right = len(rst) - 1
    while left < right:
        if rst[left] + rst[right] == n:
            print(rst[left], rst[right])
            break
        elif rst[left] + rst[right] > n:
            right -= 1
        else:
            left += 1


if __name__ == '__main__':
    goldbach(10000)
