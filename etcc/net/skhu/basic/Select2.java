package etcc.net.skhu.basic;
public class Select2 {

    static final int[] numbers = {1, 2, 3, 4};

    // numbers 배열에서 숫자 3개 선택 모든 조합
    // 선택 순서가 중요하다
    static void solution(boolean[] selected, int selectCount, int[] result) {
        if (selectCount == 3) {
            // 순서 선택 한 개가 완료되었다.
            // 그 순서를 출력하고 리턴하자.
            for (int i = 0; i < 3; ++i)
                System.out.printf("%d ", result[i]);
            System.out.println();
            return;
        }

        // 아직 선택되지 않은 수 각각을 현재 칸에 넣어보자
        for (int i = 0; i < selected.length; ++i) {
            if (selected[i] == false) { // i 위치의 수가 선택되지 않았다면
                selected[i] = true; // 그 수를 선택한다.
                result[selectCount] = numbers[i]; // 선택된 수를 result에 넣는다
                // 다음 칸에 넣을 수를 찾기 재귀호출
                solution(selected, selectCount + 1, result);
                selected[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int N = numbers.length;
        solution(new boolean[N], 0, new int[N]);
    }

}