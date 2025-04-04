package baekjoon.b01.b1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

    static int 최대버튼, 최소버튼;
    static boolean[] 고장난버튼;

    static void 고장안난최대최소버튼찾기() {
        최대버튼 = Integer.MIN_VALUE;
        최소버튼 = Integer.MAX_VALUE;
        for (int i = 0; i < 고장난버튼.length; ++i)
            if (고장난버튼[i] == false) {
                if (i < 최소버튼) 최소버튼 = i;
                if (i > 최대버튼) 최대버튼 = i;
            }
    }

    static int intValue(int[] 채널) {
        int r = 0;
        for (int i : 채널)
            r = r * 10 + i;
        return r;
    }

    static int[] 가까운채널(boolean[] 고장난버튼, int[] 채널) {
        int[] 가까운채널 = new int[채널.length];
        for (int i = 0; i < 채널.length; ++i) {
            if (고장난버튼[채널[i]] == false)
                가까운채널[i] = 채널[i];
            else {
                for (int d = 1; d <= 5; ++d) {
                    int index1 = (채널[i] + d) % 10;
                    int index2 = (채널[i] - d + 10) % 10;
                    if (고장난버튼[index1] == false) {
                        가까운채널[i] = index1;
                        for (int j = i + 1; j < 가까운채널.length; ++j)
                            가까운채널[j] = 최소버튼;
                        return 가까운채널;
                    }
                    if (고장난버튼[index2] == false) {
                        가까운채널[i] = index2;
                        for (int j = i + 1; j < 가까운채널.length; ++j)
                            가까운채널[j] = 최대버튼;
                        return 가까운채널;
                    }
                }
            }
        }
        return 가까운채널;
    }

    static int 자릿수(int value) {
        //System.out.println(String.valueOf(value));
        return String.valueOf(value).length();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] 채널 = new int[s.length()];
        for (int i = 0; i < s.length(); ++i)
            채널[i] = s.charAt(i) - '0';
        int 버튼수 = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        고장난버튼 = new boolean[10];
        for (int i = 0 ; i < 버튼수; ++i) {
            int 버튼 = Integer.parseInt(tokenizer.nextToken());
            고장난버튼[버튼] = true;
        }
        고장안난최대최소버튼찾기();
        int[] 가까운채널 = 가까운채널(고장난버튼, 채널);
        //System.out.printf("%d %d\n", 최소버튼, 최대버튼);
        System.out.println(Arrays.toString(가까운채널));
        //System.out.println(자릿수(intValue(채널)));
        int 수1 = 자릿수(intValue(가까운채널)) + Math.abs(intValue(채널) - intValue(가까운채널));
        int 수2 = Math.abs(intValue(채널) - 100);
        System.out.println(Math.min(수1, 수2));
    }
}