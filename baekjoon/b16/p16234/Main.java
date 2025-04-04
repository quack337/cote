package baekjoon.b16.p16234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Country {
        int 인구;
        boolean 동쪽국경열림, 남쪽국경열림, 방문했음;

        public Country(int 인구) {
            this.인구 = 인구;
        }

        public void  연합해제() {
            동쪽국경열림 = 남쪽국경열림 = 방문했음 = false;
        }
    }

    static boolean 국경열기(Country[][] 국가목록, int 최소차이, int 최대차이) {
        boolean 국경열림 = false;
        for (int 행 = 0; 행 < 국가목록.length; ++행)
            for (int 열 = 0; 열 < 국가목록.length; ++열) {
                if (열 < 국가목록.length - 1) {
                    int 인구차이 = Math.abs(국가목록[행][열].인구 - 국가목록[행][열+1].인구);
                    if (범위내인가(인구차이, 최소차이, 최대차이)) {
                        국가목록[행][열].동쪽국경열림 = true;
                        국경열림 = true;
                    }
                }
                if (행 < 국가목록.length - 1) {
                    int 인구차이 = Math.abs(국가목록[행][열].인구 - 국가목록[행+1][열].인구);
                    if (범위내인가(인구차이, 최소차이, 최대차이)) {
                        국가목록[행][열].남쪽국경열림 = true;
                        국경열림 = true;
                    }
                }
            }
        return 국경열림;
    }

    static boolean 범위내인가(int 값, int 최소, int 최대) {
        return 최소 <= 값 && 값 <= 최대;
    }

    static void 인구이동(Country[][] 국가목록) {
        for (int 행 = 0; 행 < 국가목록.length; ++행)
            for (int 열 = 0; 열 < 국가목록.length; ++열) {
                if (국가목록[행][열].방문했음) continue;
                List<Country> 연합국가목록 = new ArrayList<>();
                연합만들기(국가목록, 행, 열, 연합국가목록);
                인구이동(연합국가목록);
            }
    }

    static void 연합만들기(Country[][] 국가목록, int 행, int 열, List<Country> 연합국가목록) {
        if (국가목록[행][열].방문했음) return;
        국가목록[행][열].방문했음 = true;
        연합국가목록.add(국가목록[행][열]);
        if (국가목록[행][열].동쪽국경열림) 연합만들기(국가목록, 행, 열+1, 연합국가목록);
        if (국가목록[행][열].남쪽국경열림) 연합만들기(국가목록, 행+1, 열, 연합국가목록);
        if (열 > 0 && 국가목록[행][열-1].동쪽국경열림) 연합만들기(국가목록, 행, 열-1, 연합국가목록);
        if (행 > 0 && 국가목록[행-1][열].남쪽국경열림) 연합만들기(국가목록, 행-1, 열, 연합국가목록);
    }

    static void 인구이동(List<Country> 연합국가목록) {
        int 합계 = 0;
        for (Country 국가 : 연합국가목록)
            합계 += 국가.인구;
        for (Country 국가 : 연합국가목록)
            국가.인구 = 합계 / 연합국가목록.size();
    }

    static void 연합해제(Country[][] 국가목록) {
        for (int 행 = 0; 행 < 국가목록.length; ++행)
            for (int 열 = 0; 열 < 국가목록.length; ++열)
                국가목록[행][열].연합해제();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int 최소차이 = scanner.nextInt();
            int 최대차이 = scanner.nextInt();
            Country[][] 국가목록 = new Country[N][N];
            for (int 행 = 0; 행 < N; ++행)
                for (int 열 = 0; 열 < N; ++열)
                    국가목록[행][열] = new Country(scanner.nextInt());

            int 횟수 = 0;
            while (true) {
                if (국경열기(국가목록, 최소차이, 최대차이) == false) break;
                인구이동(국가목록);
                연합해제(국가목록);
                ++횟수;
            }
            System.out.println(횟수);
        }
    }
}