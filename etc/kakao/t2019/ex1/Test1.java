package net.skhu.kakao.t2019.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Test1 {

    static class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> map= new HashMap<>(); // 마지막 닉네임
            for (String s : record) {
                String[] a = s.split(" +");
                if (a.length == 3) map.put(a[1], a[2]); // 닉네임 변경
            }
            ArrayList<String> list = new ArrayList<>();
            for (String s : record) {
                String[] a = s.split(" +");
                switch (a[0]) {
                case "Enter": list.add(map.get(a[1]) + "님이 들어왔습니다."); break;
                case "Leave": list.add(map.get(a[1]) + "님이 나갔습니다."); break;
                }
            }
            return list.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        String[] a = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
                      "Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new Solution().solution(a)));
    }
}
