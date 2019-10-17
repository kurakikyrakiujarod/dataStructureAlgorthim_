package test;

public class TestHanoi {
    public static void hanoi(int n, char from, char in, char to) {
        if (n == 1) System.out.println("第1个盘子从" + from + "移到" + to);
        else {
            hanoi(n - 1, from, to, in);
            System.out.println("第" + n + "个盘子从" + from + "移到" + to);
            hanoi(n - 1, in, from, to);
        }
    }

    public static void main(String[] args) {
        hanoi(3, 'A', 'B', 'C');
    }
}
