package etcc.net.skhu.programmers2019;
public class Exam1 {

    static int solution(int[] s) {
        int[] 그룹수 = new int[5];
        for (int 그룹크기 : s)
            ++그룹수[그룹크기];

        int 택시수 = 그룹수[4]; // 그룹4 탑승 완료

        int 그룹3과1 = Math.min(그룹수[3], 그룹수[1]);
        택시수 += 그룹3과1;
        그룹수[1] -= 그룹3과1;
        그룹수[3] -= 그룹3과1;  // 그룹3 + 그룹1 합승 완료

        택시수 += 그룹수[3] ;   // 그룹3 탐승 완료

        택시수 += (그룹수[2] / 2); // 그룹2 + 그룹2 합승 완료
        그룹수[2] = 그룹수[2] % 2; // 남은 그룹2 수는 1 or 0
        if (그룹수[2] == 1)  {
            ++택시수;
            그룹수[1] = Math.max(그룹수[1] - 2, 0); // 남은 그룹2 + 그룹1 탐승 완료
        }

        택시수 += (그룹수[1] + 3) / 4; //  (그룹수[1] / 4) 올림. 그룹1 탑승 완료
        return 택시수;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] { 1,2,4,3,3 }));          // 4
        System.out.println(solution(new int[] { 2,3,4,4,2,1,3,1 }));    // 5

        System.out.println(solution(new int[] { 1,1,1,1,1,2 }));        // 2
        System.out.println(solution(new int[] { 1,1,1,1,1,1,2 }));      // 2
        System.out.println(solution(new int[] { 1,1,1,1,1,1,2,1 }));    // 3
        System.out.println(solution(new int[] { 1,1,3,1,1,1,1,2,1 }));  // 3
        System.out.println(solution(new int[] { 1,1,4,1,1,1,1,2,1 }));  // 4
        System.out.println(solution(new int[] { 1,1,4,1,1,1,1,2,2 }));  // 4
        System.out.println(solution(new int[] { 1,1,4,1,1,1,1,2,3 }));  // 4
        System.out.println(solution(new int[] { 1,1,4,1,1,1,1,2,4 }));  // 4
        System.out.println(solution(new int[] { 1,1,4,1,1,1,1,3,4 }));  // 5
        System.out.println(solution(new int[] { 1,1,4,1,1,1,2,3,4 }));  // 5
        System.out.println(solution(new int[] { 1,1,4,2,1,1,2,3,4 }));  // 5
        System.out.println(solution(new int[] { 1,1,4,3,1,1,2,3,4 }));  // 5
        System.out.println(solution(new int[] { 1,2,4,3,1,1,2,3,4 }));  // 6
    }
}