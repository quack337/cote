package baekjoon.p01.p1107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] 고장난버튼;

    static boolean 입력할수있는가(int 채널) {
        char[] 번호목록 = String.valueOf(채널).toCharArray();
        for (char 번호 : 번호목록) {
            if (고장난버튼[번호 - '0']) return false;
        }
        return true;
    }

    static int 가까운채널(int 채널) {
        if (입력할수있는가(채널)) return 채널;
        for (int i = 0; i <= 500000; ++i) { // 가까운 순서대로 주변 채널을 조사한다
            if (채널-i >= 0 && 입력할수있는가(채널-i)) return 채널-i; // 아랫 번호를 입력할 수 있는가
            if (입력할수있는가(채널+i)) return 채널+i; // 윗 번호를 입력할 수 있는가?
        }
        return -1;
    }

    static int 자릿수(int value) {
        return String.valueOf(value).length();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int 채널 = Integer.parseInt(reader.readLine());
        int 고장난버튼수 = Integer.parseInt(reader.readLine());
        고장난버튼 = new boolean[10];
        if (고장난버튼수 > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0 ; i < 고장난버튼수; ++i) {
                int 버튼 = Integer.parseInt(tokenizer.nextToken());
                고장난버튼[버튼] = true;
            }
        }
        if (고장난버튼수 == 10) {
            System.out.println(Math.abs(채널 - 100)); // + - 버튼만 누르기
        } else {
            int 가까운채널 = 가까운채널(채널);
            int 수1 = 자릿수(가까운채널) + Math.abs(채널 - 가까운채널); // 가까운채널을 누르고, + - 버튼 누르기
            int 수2 = Math.abs(채널 - 100); // 100번에서시작해서 + - 버튼 누르기
            System.out.println(Math.min(수1, 수2));
        }
    }
}