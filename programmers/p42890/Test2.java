package programmers.p42890;

import java.util.ArrayList;

public class Test2 {

    static int[] 목록 = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };

    @SuppressWarnings("unchecked")
    static void 선택(int 선택크기, int 현재단계, ArrayList<Integer> 선택목록) {
        if (선택목록.size() == 선택크기) {
            System.out.println(선택목록);
            return;
        }
        if ((선택크기 - 선택목록.size()) > (목록.length - 현재단계)) return;
        선택(선택크기, 현재단계 + 1, 선택목록);
        var 새선택목록 = (ArrayList<Integer>)선택목록.clone();
        새선택목록.add(목록[현재단계]);
        선택(선택크기, 현재단계 + 1, 새선택목록);
    }

    public static void main(String[] args) {
        선택(3, 0, new ArrayList<>());
    }
}