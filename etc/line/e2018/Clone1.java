package line.e2018;

import java.util.ArrayList;

public class Clone1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        // 이 시점에서 list 변수가 참조하는 객체의 값은 [1, 2] 이다.
        ArrayList<Integer> list2 = list; // list2 변수는 list 변수와 동일한 객체를 참조함.

        // list 변수가 참조하는 객체를 복제해서 새 객체가 생성됨.
        ArrayList<Integer> list3 = (ArrayList<Integer>)list.clone();

        list.add(3);
        list.add(4);

        // 이 시점에서 list 변수가 참조하는 객체의 값은 [1,2,3,4] 이다.
        System.out.println(list2); // list 변수가 참조하는 객체가 출력됨. [1,2,3,4]
        System.out.println(list3); // 위에서 복제한 객체가 출력됨. [1,2]
    }
}
