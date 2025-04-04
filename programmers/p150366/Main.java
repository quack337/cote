package programmers.p150366;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static class Solution {
        static class Cell {
            String value;
        }

        public String[] solution(String[] commands) {
            var answer = new ArrayList<String>();
            var cells = new Cell[50][50];
            for (int r = 0; r < 50; ++r)
                for (int c = 0; c < 50; ++c)
                    cells[r][c] = new Cell();
            for (String cmd : commands) {
                var a = cmd.split(" +");
                if ("UPDATE".equals(a[0])) {
                    if (a.length == 4) {
                        int r = Integer.parseInt(a[1]) - 1;
                        int c = Integer.parseInt(a[2]) - 1;
                        cells[r][c].value = a[3];
                    } else {
                        String value1 = a[1];
                        String value2 = a[2];
                        for (int r = 0; r < 50; ++r)
                            for (int c = 0; c < 50; ++c)
                                if (value1.equals(cells[r][c].value))
                                    cells[r][c].value = value2;
                    }
                }
                else if ("MERGE".equals(a[0])) {
                    int r1 = Integer.parseInt(a[1]) - 1;
                    int c1 = Integer.parseInt(a[2]) - 1;
                    int r2 = Integer.parseInt(a[3]) - 1;
                    int c2 = Integer.parseInt(a[4]) - 1;
                    Cell cellTo = cells[r1][c1];
                    Cell cellFrom = cells[r2][c2];
                    if (cells[r1][c1].value == null) {
                        cellFrom = cells[r1][c1];
                        cellTo = cells[r2][c2];
                    }
                    for (int r = 0; r < 50; ++r)
                        for (int c = 0; c < 50; ++c)
                            if (cells[r][c] == cellFrom)
                                cells[r][c] = cellTo;
                }
                else if ("UNMERGE".equals(a[0])) {
                    int r1 = Integer.parseInt(a[1]) - 1;
                    int c1 = Integer.parseInt(a[2]) - 1;
                    Cell cell = cells[r1][c1];
                    for (int r = 0; r < 50; ++r)
                        for (int c = 0; c < 50; ++c)
                            if (cells[r][c] == cell)
                                cells[r][c] = new Cell();
                    cells[r1][c1] = cell;
                }
                else if ("PRINT".equals(a[0])) {
                    int r = Integer.parseInt(a[1]) - 1;
                    int c = Integer.parseInt(a[2]) - 1;
                    answer.add(cells[r][c].value == null ? "EMPTY" : cells[r][c].value);
                }
            }
            return answer.toArray(new String[answer.size()]);
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var cmds = new String[] {"UPDATE 1 1 menu", "UPDATE 1 2 category",
                "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice",
                "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean",  "UPDATE 3 3 noodle",
                "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
                "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4",
                "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4",
                "PRINT 1 3", "PRINT 1 4" };
        System.out.println(Arrays.toString(sol.solution(cmds)));
        cmds = new String[] {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c",
                "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1",
                "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1" };
        System.out.println(Arrays.toString(sol.solution(cmds)));
    }
}