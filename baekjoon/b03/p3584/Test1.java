package baekjoon.b03.p3584;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {

    public static void main(String[] args) {
        var list1 = new ArrayList<Integer>();
        list1.add(3);
        list1.add(4);
        list1.add(5);
        Collections.reverse(list1);
        System.out.println(list1);
    }

}