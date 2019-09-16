def plusOne(digits):
    if len(digits) == 0:
        return False
    addCarry = 1
    for i in range(len(digits) - 1, -1, -1):
        digits[i] += addCarry
        if digits[i] == 10:
            digits[i] = 0
            if i == 0:
                digits.insert(0, 1)
        else:
            break
    return digits


if __name__ == '__main__':
    digits = [1, 2, 3]
    print(plusOne(digits))
    digits = [9, 9, 9]
    print(plusOne(digits))
