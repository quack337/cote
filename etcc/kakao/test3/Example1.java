package etcc.kakao.test3;
class LRUCache {

    static int current = 0; // 현재 시각

    static class Item {
        Object data;        // 캐시에 저장될 데이터
        int accessTime;     // 최근 읽은 시각

        Item(Object data) {
            this.data = data;
            this.accessTime = ++current; // 현재 시각 대입
        }
    }

    Item[] items;

    public LRUCache(int size) {
        items = new Item[size];
    }

    public boolean contains(Object data) {
        for (int i = 0; i < items.length; ++i)
            if (items[i] != null && items[i].data.equals(data)) {
                items[i].accessTime = ++current; // 읽은 시각 갱신
                return true;
            }
        return false;
    }

    public void add(Object data) {
        int min = Integer.MAX_VALUE; // LRU 항목을 찾기 위한 시각
        int index = -1;              // LRU 항목을 찾기 위한 index
        for (int i = 0; i < items.length; ++i) {
            if (items[i] == null) { // 비칸이 있으면, 여기에 저장하고 리턴
                items[i] = new Item(data);
                return;
            } else if (items[i].accessTime < min) { // LRU 항목 찾기
                min = items[i].accessTime;
                index = i;
            }
        }
        if (index >= 0)
            items[index] = new Item(data); // LRU 항목 위치에 덮어쓰기
    }
}

public class Example1 {

    static int calculateTime(String[] a, int cacheSize) {
        LRUCache cache = new LRUCache(cacheSize);
        int time = 0;
        for (String s : a) {
            s = s.toLowerCase();
            if (cache.contains(s))
                time += 1;
            else {
                cache.add(s);
                time += 5;
            }
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