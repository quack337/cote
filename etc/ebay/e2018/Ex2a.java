package ebay.e2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 2018 문제 2번
 두개의 문장이 주어진다.
 첫번째 문장(s)과 두번째 문장(t)이 주어진다.

 예를 들어
 s : I am using HackerRank to improve programing
 t : am HackerRank to improve
 이렇게 두 문장이 주어지면
 결과는
 I
 using
 programing
 이다.

 문장 최대 길이는 10^6
 한 단어의 개수가 15를 넘지 않는다.

 */
public class Ex2a {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = br.readLine();
        StringTokenizer firstToken = new StringTokenizer(firstInput);

        String lastInput = br.readLine();
        StringTokenizer lastToken = new StringTokenizer(lastInput);

        br.close();

        String[] first = new String[firstToken.countTokens()];
        String[] last = new String[lastToken.countTokens()];

        int i = 0;
        int j = 0;
        while (firstToken.hasMoreTokens()) {
            first[i++] = firstToken.nextToken();
        }

        while (lastToken.hasMoreTokens()) {
            last[j++] = lastToken.nextToken();
        }

        for (int k = 0; k < last.length; ++k) {
            for (int l = 0; l < first.length; ++l) {
                if (last[k].equals(first[l])) {
                    first[l] = "@";
                    break;
                }
            }
        }

        //print
        for (int k = 0; k < first.length; ++k) {
            if (!first[k].equals("@")) {
                System.out.println(first[k]);
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println("걸린 시간 : " + estimatedTime / 1000.0 + " milli seconds");
    }
}
