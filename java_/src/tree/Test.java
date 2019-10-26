package tree;

public class Test {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
    }
}
