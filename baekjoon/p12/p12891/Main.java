package baekjoon.p12.p12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] 최소 = new int[4];
    static int[] 개수 = new int[4];
    static int answer = 0;

    static void checkAnswer() {
      for (int i = 0; i < 4; ++i)
        if (개수[i] < 최소[i]) return;
      ++answer;
    }

    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        int S = Integer.parseInt(tokennizer.nextToken());;
        int P = Integer.parseInt(tokennizer.nextToken());;
        char[] DNA = reader.readLine().toCharArray();
        s = reader.readLine();
        tokennizer = new StringTokenizer(s);
        최소[0] = Integer.parseInt(tokennizer.nextToken());;
        최소[1] = Integer.parseInt(tokennizer.nextToken());;
        최소[2] = Integer.parseInt(tokennizer.nextToken());;
        최소[3] = Integer.parseInt(tokennizer.nextToken());;
        reader.close();
        for (int i = 0; i < DNA.length; ++i) {
          ++개수["ACGT".indexOf(DNA[i])];
          if (i >= P)
            --개수["ACGT".indexOf(DNA[i - P])];
          if (i >= P - 1)
            checkAnswer();
        }
        System.out.println(answer);
    }
}
