def ruler(n):
    if n == 1:
        return "1"
    t = ruler(n - 1)
    return t + " " + str(n) + " " + t


def ruler2(n):
    result = ""
    for i in range(1, n + 1):
        result = result + str(i) + " " + result
    return result


def draw_line(tick_length, tick_label=''):
    line = '-' * tick_length
    if tick_label:
        line += ' ' + tick_label
    print(line)


def draw_interval(center_length):
    if center_length > 0:
        draw_interval(center_length - 1)
        draw_line(center_length)
        draw_interval(center_length - 1)


def draw_rule(num_inches, major_length):
    draw_line(major_length, '0')
    for j in range(1, 1 + num_inches):
        draw_interval(major_length - 1)
        draw_line(major_length, str(j))


if __name__ == '__main__':
    # print(ruler(5))
    # print(ruler2(5))
    # draw_line(5, '5')
    draw_interval(2)
    # print('\n\n')
    draw_rule(3, 3)
