package programmers.p42890;
import java.util.ArrayList;
import java.util.HashSet;

public class Test1 {

    static class Solution {
        ArrayList<HashSet<Integer>> 후보키목록 = new ArrayList<>();
        String[][] 레코드목록;

        boolean 최소성(HashSet<Integer> 속성집합) {
            for (HashSet<Integer> 후보키 : 후보키목록) {
               if (후보키.size() >= 속성집합.size()) break;
               if (속성집합.containsAll(후보키)) return false;
            }
            return true;
         }

        boolean 유일성(HashSet<Integer> 속성집합) {
            HashSet<String> 값목록 = new HashSet<>();
            for (String[] 레코드 : 레코드목록) {
                String 값 = 값추출(레코드, 속성집합);
                if (값목록.contains(값)) return false;
                값목록.add(값);
            }
            return true;
        }

        String 값추출(String[] 레코드, HashSet<Integer> 속성집합) {
            StringBuilder builder = new StringBuilder();
            for (int 속성 : 속성집합)
                builder.append(레코드[속성]).append(" ");
            return builder.toString();
        }

        @SuppressWarnings("unchecked")
        void 속성선택(int 선택크기, int 현재속성, HashSet<Integer> 속성집합) {
            if (속성집합.size() == 선택크기) {
                if (최소성(속성집합) && 유일성(속성집합))
                    후보키목록.add(속성집합);
                return;
            }
            if ((선택크기 - 속성집합.size()) > (레코드목록[0].length - 현재속성)) return;
            속성선택(선택크기, 현재속성 + 1, 속성집합);
            var 새속성집합 = (HashSet<Integer>)속성집합.clone();
            새속성집합.add(현재속성);
            속성선택(선택크기, 현재속성 + 1, 새속성집합);
        }

        public int solution(String[][] relation) {
            this.레코드목록 = relation;
            for (int 선택크기 = 1; 선택크기 <= 레코드목록[0].length; ++선택크기)
                속성선택(선택크기, 0, new HashSet<Integer>());
            return 후보키목록.size();
        }
    }

    public static void main(String[] args) {
        String[][] a = {{"100","ryan","music","2"},{"200","apeach","math","2"},
                        {"300","tube","computer","3"},{"400","con","computer","4"},
                        {"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(new Solution().solution(a));
    }
}