package line.e2018;

import java.util.Arrays;

public class Schedule1 {

    static void schedule(boolean[] selected, int index) {
        if (index >= selected.length) {
            System.out.println(Arrays.toString(selected));
            return;
        }
        selected[index] = true;
        schedule(selected, index + 1);
        selected[index] = false;
        schedule(selected, index + 1);
    }

    public static void main(String[] args) {
        schedule(new boolean[3], 0);
    }
}