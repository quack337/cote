public class Test {

    public static void main(String[] args) {
        final int N = 5;
        for (int a = 1; a <= N - 2; ++a)
        for (int b = a + 1; b <= N - 1; ++b)
        for (int c = b + 1; c <= N; ++c)
            System.out.printf("(%d %d %d) ", a, b, c);
    }
}