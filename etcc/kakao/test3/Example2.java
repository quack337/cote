package etcc.kakao.test3;
public class Example2 {

    static int calculateTime(String[] a, int cacheSize) {
        int time = 0;
        for (int i = 0; i < a.length; ++i) {
            for (int j = 1; j <= cacheSize; ++j)
                if (i - j >= 0 && a[i].compareToIgnoreCase(a[i - j]) == 0) {
                    time -= 4;
                    break;
                }
            time += 5;
        }
        return time;
    }

    public static void main(String[] args) {
        String[][] list = new String[][] {
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"},
            {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
                "Jeju", "NewYork", "Rome"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
                "Jeju", "NewYork", "Rome"},
            {"Jeju", "Pangyo", "NewYork", "newyork"},
            {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
        int[] cacheSize = { 3, 3, 2, 5, 2, 0 };

        for (int i = 0 ; i < list.length; ++i) {
            System.out.printf("%d \n", calculateTime(list[i], cacheSize[i]));
        }
    }

}