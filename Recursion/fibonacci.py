def fibonacci3(n):
    if n <= 1:
        return n, 0
    a, b = fibonacci3(n - 1)
    return a + b, a


print(fibonacci3(5))
