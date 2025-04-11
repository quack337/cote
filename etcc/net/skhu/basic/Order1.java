package etcc.net.skhu.basic;
import java.util.Arrays;

public class Order1 {

    static int[] numbers;

    //
    static void order(int index, int[] result) {
        if (index >= result.length) {
            // 순서 선택 한 개가 완료되었다.
            // 그 순서를 출력하고 리턴하자.
            System.out.println(Arrays.toString(result));
            return;
        }

        // numbers[index] 수의 순서를 정해야 한다.
        // 즉 result 배열의 빈 칸 중 하나에 numbers[index] 수를 넣어야 한다.
        // 빈 칸 각각에 대해서 시도해 보자.
        for (int i = 0; i < result.length; ++i) {
            if (result[i] != 0) continue; // 빈 칸이 아니면 무시

            int[] result1 = result.clone(); // 각각의 경우마다 배열이 따로 만들어져야 한다.
                                            // 즉 가능한 순서가 8개라면, result 배열도 8개 만들어야 한다.

            result1[i] = numbers[index]; // numbers[index] 수를 result[i] 위치에 선택한다.
            order(index + 1, result1);   // 나머지 수들의 순서도 선택해야 한다.
        }

    }

    public static void main(String[] args) {
        numbers = new int[] {1, 2, 3};
        order(0, new int[numbers.length]);
    }
}