# O(m+n) space complexity
def zero(matrix):
    m = [None] * len(matrix)
    n = [None] * len(matrix[0])
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == 0:
                m[i] = 1
                n[j] = 1

    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if m[i] == 1 or n[j] == 1:
                matrix[i][j] = 0

if __name__ == '__main__':
    matrix = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
              [1, 1, 1, 0, 1, 1, 1, 1, 1, 1],
              [1, 1, 0, 1, 1, 1, 1, 1, 1, 1],
              [1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
              [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

    for x in matrix:
        print(x, sep=" ")

    print()
    zero(matrix)
    for x in matrix:
        print(x, sep=" ")
