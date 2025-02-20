package net.skhu.line.e2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule1a {

    static int countTrue(boolean[] selected) {
        int count = 0;
        for (boolean b : selected)
            if (b) ++count;
        return count;
    }

    static List<boolean[]> list = new ArrayList<boolean[]>();

    static void schedule(boolean[] selected, int index) {
        if (index >= selected.length) {
            System.out.println(Arrays.toString(selected));
            if (countTrue(selected) % 2 == 0) list.add(selected);
            return;
        }
        selected[index] = true;
        schedule(selected, index + 1);
        selected[index] = false;
        schedule(selected, index + 1);
    }

    public static void main(String[] args) {
        schedule(new boolean[3], 0);
        System.out.println("----------");
        for (boolean[] a : list)
            System.out.println(Arrays.toString(a));
    }
}
