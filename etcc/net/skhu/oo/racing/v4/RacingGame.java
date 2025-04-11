package etcc.net.skhu.oo.racing.v4;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    static int getMaxPositionValue(List<Car> cars) {
        int max = 0;
        for (Car car : cars)
            if (car.getPosition() > max)
                max = car.getPosition();
        return max;
    }

    static List<Car> findCarsByPosition(List<Car> cars, int position) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars)
            if (car.getPosition() == position)
                result.add(car);
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            String line = scanner.nextLine();

            List<Car> cars = new ArrayList<>();
            for (String name : line.split("[ ,\r\n]+"))
                cars.add(new Car(name));

            System.out.println("시도할 최수는 몇회인가요?");
            int runCount = scanner.nextInt();

            System.out.println("실행결과");
            Random random = new Random();

            for (int i = 0; i < runCount; ++i) {
                for (Car car : cars) {
                    if (random.nextInt(10) > 3)
                        car.setPosition(car.getPosition() + 1);
                    // 자동차 달린 거리 출력
                    System.out.println(car);
                }
                System.out.println();
            }
            int maxPosition = getMaxPositionValue(cars);  // 최대 거리 찾기
            List<Car> winner = findCarsByPosition(cars, maxPosition); // 우승자 찾기
            // 우승자 출력
            for (int i = 0; i < winner.size(); ++i) {
                if (i > 0) System.out.print(",");
                System.out.print(winner.get(i).getName());
            }
            System.out.println("가 최종 우승했습니다.");
        }
    }
}