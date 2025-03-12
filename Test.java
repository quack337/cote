import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");

        System.out.println(set1.size()); // 3
        System.out.println(set1.contains("a")); // true
        System.out.println(set1.contains("d")); // false

        set1.remove("a");
        System.out.println(set1.size()); // 2
        System.out.println(set1.contains("a")); // false

        Set<String> set2 = new HashSet<>(Set.of("a", "b", "c", "d"));
        System.out.println(set2.size()); // 4

        // set1과 set2의 교집합 구하기
        Set<String> set3 = new HashSet<>(set1); // set1을 복사해서 set3를 만듦
        set3.retainAll(set2); // set3에 set2와의 교집합만 남기고 나머지는 제거

        System.out.println(set3); // [b, c]
    }
}
