def rotate(matrix):
    n = len(matrix)
    result = [[0] * n for i in range(n)]

    for i in range(n):
        for j in range(n):
            result[j][n - 1 - i] = matrix[i][j]

    for x in result:
        print(x, sep=" ")


# in-place
def rotate_in_place(matrix):
    n = len(matrix)
    for layer in range(n // 2):
        first = layer
        last = n - 1 - layer
        for i in range(first, last):
            offset = i - first
            top = matrix[first][i]  # save top

            # left->top
            matrix[first][i] = matrix[last - offset][first]

            # bottom -> left
            matrix[last - offset][first] = matrix[last][last - offset]

            # right -> bottom
            matrix[last][last - offset] = matrix[i][last]

            # top -> right
            matrix[i][last] = top  # right <- saved top

    for x in matrix:
        print(x, sep=" ")


if __name__ == '__main__':
    matrix = [[i * 5 + j for j in range(5)] for i in range(5)]
    # rotate(matrix)
    rotate_in_place(matrix)
