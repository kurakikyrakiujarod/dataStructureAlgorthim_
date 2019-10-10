package designPattern;

class ToolUtil {
    int num = 1;
    private static ToolUtil instance = new ToolUtil();

    private ToolUtil() {
    }

    static public ToolUtil getInstance() {
        return instance;
    }

    public void show() {
        System.out.println(num);
        this.num++;
    }
}

public class SingleDesign {
    public static void main(String[] args) {
        ToolUtil u1 = ToolUtil.getInstance();
        ToolUtil u2 = ToolUtil.getInstance();
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u1 == u2);
        u1.show();
        u2.show();
        u1.show();
    }
}
