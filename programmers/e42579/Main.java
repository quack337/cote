public class Main {

    static class Solution {
        static final int 번호 = 0, 재생수 = 1;
        static class 장르정보 {
            int 총재생수; int[][] 곡목록;
        }

        public int[] solution(String[] genres, int[] plays) {
            var 장르정보맵 = new java.util.HashMap<String, 장르정보>();
            for (int i = 0; i < genres.length; i++) {
                var 장르명 = genres[i];
                var 정보 = 장르정보맵.get(장르명);
                if (정보 == null) {
                    정보 = new 장르정보();
                    정보.총재생수 = 0;
                    정보.곡목록 = new int[][] {{-1, -1}, {-1, -1}};
                    장르정보맵.put(장르명, 정보);
                }
                정보.총재생수 += plays[i];
                if (plays[i] > 정보.곡목록[0][재생수]) {
                    정보.곡목록[1] = 정보.곡목록[0];
                    정보.곡목록[0] = new int[] {i, plays[i]};
                } else if (plays[i] > 정보.곡목록[1][재생수])
                    정보.곡목록[1] = new int[] {i, plays[i]};
            }
            var 장르정보목록= 장르정보맵.values().stream()
                    .sorted((a, b) -> b.총재생수 - a.총재생수)
                    .collect(java.util.stream.Collectors.toList());
            var 답목록 = new java.util.ArrayList<Integer>();
            for (var 장르정보 : 장르정보목록) {
                답목록.add(장르정보.곡목록[0][번호]);
                if (장르정보.곡목록[1][번호] != -1)
                    답목록.add(장르정보.곡목록[1][번호]);
            }
            return 답목록.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        var solution = new Solution();
        var result = solution.solution(
            new String[] {"classic", "pop", "classic", "classic", "pop"},
            new int[] {500, 600, 150, 800, 2500});
        System.out.println(java.util.Arrays.toString(result));
    }
}