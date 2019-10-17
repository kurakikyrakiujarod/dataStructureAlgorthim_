package test;

class SoftThread extends Thread {
    private int value;

    public SoftThread(int value) {
        this.value = value;
    }

    public void run() {
        try {
            Thread.sleep(value);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        int[] array = {10, 100, 12, 34, 30, 60};
        for (int i = 0; i < array.length; i++) {
            new SoftThread(array[i]).start();
        }
    }
}
