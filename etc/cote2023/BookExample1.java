public class BookExample1 {

  public static void main(String[] args) {
    final int N = 1_000_000_000;
    int value = (int)(Math.random() * N);
    for (int i = 0; i < N; ++i)
      if (i == value) {
        System.out.println(i);
        break;
      }
  }
}
