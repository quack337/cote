package kakao.test5;

public class Example1 {

    static int solution(int rowCount, int colCount, String[] board) {
        int totalCount = 0;                 // 제거된 칸의 총 수
        char[][] a = new char[rowCount][];  // 게임판 2차원 배열
        for (int r = 0; r < rowCount; ++r)  // 게임판 2차원 배열 만들기
            a[r] = board[r].toCharArray();

        while (true) {
            boolean[][] b = new boolean[rowCount][colCount]; // 제거할 칸을 표시하기 위한 배열
            for (int r = 0; r < rowCount - 1; ++r)  // 제거할 칸 찾기
                for (int c = 0; c < colCount - 1; ++c)
                    if (a[r][c]!=0 && a[r][c]==a[r][c+1] && a[r][c]==a[r+1][c] && a[r][c]==a[r+1][c+1])
                        b[r][c] = b[r][c+1] = b[r+1][c] = b[r+1][c+1] = true; // 제거할 칸 표시
            int count = 0; // 이번에 제거된 칸의 수
            for (int c = 0; c < colCount; ++c) {
                int index = rowCount - 1; // 제거하지 않을 칸만 차례로 쌓기 위한 인덱스
                for (int r = rowCount - 1; r >= 0; --r)
                    if (b[r][c]) ++count;          // 제거할 칸인 경우
                    else a[index--][c] = a[r][c];  // 제거하지 않을 칸만 차례로 쌓기
                for (int r = index; r >= 0; --r)   // 빈 칸에 0 채우기
                    a[r][c] = 0;
            }
            totalCount = totalCount + count;
            if (count == 0) return totalCount; // 제거된 칸이 없으면 리턴
       }
    }

    public static void main(String[] args) {
        String[] a1 = { "CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] a2 = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(4, 5, a1));
        System.out.println(solution(6, 6, a2));
    }
}