package etcc.net.skhu.basic;
public class Float1 {
    public static void main(String[] args) {
        double a = 0.3 * 3;
        System.out.println(a);

        double b = 0.9;
        System.out.println(b);

        System.out.println(a == b);

        System.out.println(Math.abs(a - b));
        System.out.println(Math.ulp(a));
        System.out.println(Math.ulp(b));
    }
}