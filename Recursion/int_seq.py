def intSeq(a, b):
    if a == b:
        return str(a)

    if b % 2 == 1:
        return "(" + intSeq(a, b - 1) + " + 1)"

    if b < a * 2:
        return "(" + intSeq(a, b - 1) + " + 1)"

    return intSeq(a, b // 2) + " * 2";


if __name__ == '__main__':
    a = 5
    b = 101
    print(str(b) + " = " + intSeq(a, b))
