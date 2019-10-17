package com.mj.sort;


public abstract class Sort {
    protected int[] array;
    private int cmpCount;
    private int swapCount;
    private long time;

    public void sort(int[] array) {
        if (array == null || array.length < 2) return;

        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    protected abstract void sort();

    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1] - array[i2];
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + cmpCount;
        String swapCountStr = "交换：" + swapCount;
        return "【" + getClass().getSimpleName() + "】\n"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";

    }


}
