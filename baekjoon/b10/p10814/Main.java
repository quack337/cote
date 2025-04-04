package baekjoon.b10.p10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Member implements Comparable<Member> {
        int no, age;
        String name;

        public Member(int no, int age, String name) {
            this.no = no;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member m) {
            int r = this.age - m.age;
            if (r != 0) return r;
            return this.no - m.no; // 입력 순서
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Member[] A = new Member[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int age = Integer.parseInt(tokenizer.nextToken());
            String name = tokenizer.nextToken();
            A[i] = new Member(i, age, name);
        }
        Arrays.sort(A);
        for (Member m : A)
            System.out.println(m);
    }
}