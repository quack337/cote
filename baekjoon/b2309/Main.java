package baekjoon.b2309;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int sum(List<Integer> list) {
        int result = 0;
        for (int i : list)
            result += i;
        return result;
    }

    static boolean 탐색(int[] A, int index, List<Integer> selected) {
        if (selected.size() == 7)
            return sum(selected) == 100;
        if (A.length - index > 7 - selected.size())
            if (탐색(A, index+1, selected)) return true;
        selected.add(A[index]);
        if (탐색(A, index+1, selected)) return true;
        selected.remove(selected.size() - 1);
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[9];
        for (int i = 0; i < 9; ++i)
            A[i] = Integer.parseInt(reader.readLine());
        Arrays.sort(A);
        ArrayList<Integer> selected = new ArrayList<Integer>();
        탐색(A, 0, selected);
        for (int i : selected)
            System.out.println(i);
    }
}