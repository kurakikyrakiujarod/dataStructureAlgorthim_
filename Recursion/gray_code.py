# https://www.cnblogs.com/0201zcr/p/4796950.html
# https://www.jianshu.com/p/c9969096bf9a


def gray_code(n):  # 递归，代码简单，速度较应用序慢
    if n == 1:
        return ['0', '1']
    return ['0' + i for i in gray_code(n - 1)] + ['1' + i for i in gray_code(n - 1)[::-1]]


def gray_code_for_2(n):  # 循环顺序实现，速度优势
    lst = ['0', '1']
    for i in range(1, n):
        left = ['0' + i for i in lst]
        right = ['1' + i for i in lst[::-1]]
        lst = left + right
    return lst


if __name__ == '__main__':
    for i in gray_code(5):
        print(i)
