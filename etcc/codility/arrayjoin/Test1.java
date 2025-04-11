package etcc.codility.arrayjoin;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        String[] a = { "one", "two", "three" };

        String s = String.join(",", a);
        System.out.println(s);

        String[] b = s.split(",");
        System.out.println(Arrays.toString(b));
    }

}