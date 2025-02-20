package net.skhu.oo.racing.v8;

import static java.util.stream.Collectors.toList;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    static final String PROMPT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    static final String PROMPT_FOR_RUN_COUNT = "시도할 최수는 몇회인가요?";
    static final String RESULT_TITLE = "실행결과";
    static final String WINNER_FORMAT_STRING = "%s가 최종 우승했습니다.\n";

    static UserInput getUserInput(InputStream in) {
        try (Scanner scanner = new Scanner(in)) {
            UserInput input = new UserInput();
            System.out.println(PROMPT_FOR_CAR_NAMES);
            input.setCarNames(scanner.nextLine().split("[ ,\r\n]+"));
            System.out.println(PROMPT_FOR_RUN_COUNT);
            input.setRunCount(scanner.nextInt());
            return input;
        }
    }

    static List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name)).collect(toList());
    }

    static int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition).max().getAsInt();
    }

    static List<Car> findCarsByPosition(List<Car> cars, int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position).collect(toList());
    }

    static String[] getCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName).toArray(String[]::new);
    }

    public static void main(String[] args) {
        UserInput userInput = getUserInput(System.in);
        List<Car> cars = createCars(userInput.getCarNames());
        System.out.println(RESULT_TITLE);
        Random random = new Random();
        for (int i = 0; i < userInput.getRunCount(); ++i) {
            for (Car car : cars) {
                int steps = (random.nextInt(10) > 3) ? 1 : 0;
                car.moveForwardBySteps(steps);
                System.out.println(car);
            }
            System.out.println();
        }
        int maxPosition = getMaxPosition(cars);
        List<Car> winner = findCarsByPosition(cars, maxPosition);
        String[] winnerNames = getCarNames(winner);
        System.out.printf(WINNER_FORMAT_STRING, String.join(",", winnerNames));
    }
}
