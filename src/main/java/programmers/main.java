package programmers;

public class main {
    public static void main(String[] args) {
        int a = 1;
        int b = ++a + a++ + ++a;
        System.out.println(a);

        System.out.println(b);
    }
}
