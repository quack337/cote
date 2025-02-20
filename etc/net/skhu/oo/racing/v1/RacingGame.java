package net.skhu.oo.racing.v1;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String line = scanner.nextLine();
            String[] cars = line.split("[ ,\r\n]+");
            System.out.println("시도할 최수는 몇회인가요?");
            int runCount = scanner.nextInt();

            System.out.println("실행결과");
            Random random = new Random();
            int[] distance = new int[cars.length]; // 자동차가 달린 거리
            for (int i = 0; i < runCount; ++i) {
                for (int c = 0; c < cars.length; ++c) {
                    if (random.nextInt(10) > 3)
                        ++distance[c];
                    // 자동차 달린 거리 출력
                    System.out.print(cars[c] + ":");
                    for (int d = 0; d < distance[c]; ++d)
                        System.out.print("-");
                    System.out.println();
                }
                System.out.println();
            }
            // 최대 거리 찾기
            int max = 0;
            for (int c = 0; c < cars.length; ++c)
                if (distance[c] > max)
                    max = distance[c];
            // 우승자 찾기
            int count = 0;
            for (int c = 0; c < cars.length; ++c)
                if (distance[c] == max) {
                    if (++count > 1) System.out.print(",");
                    System.out.print(cars[c]);
                }
            System.out.println("가 최종 우승했습니다.");
        }
    }
}

