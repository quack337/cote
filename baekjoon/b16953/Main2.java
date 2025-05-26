package baekjoon.b16953;
// 정답

import java.io.*;
import java.util.*;

public class Main2 {

  static int sol(int A, int B) {
    int count = 1;
    while (B > A) {
      if (B % 2 == 0) B = B / 2;
      else if (B % 10 == 1) B = B / 10;
      else return -1;
      ++count;
    }
    return B == A ? count : -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int A = scanner.nextInt(), B = scanner.nextInt();
    scanner.close();
    System.out.println(sol(A, B));
  }
}