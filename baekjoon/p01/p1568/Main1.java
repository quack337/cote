package baekjoon.p01.p1568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static class Person {
        int index, weight, height, rank;
        public Person(int index, int weight, int height) {
            this.index = index;
            this.weight = weight;
            this.height = height;
        }
        @Override
        public String toString() {
            return "(" + weight + "," + height + ")";
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Person[] A = new Person[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());
            A[i] = new Person(i, w, h);
        }
        Arrays.sort(A, (p1, p2) -> {
            if (p1.weight > p2.weight && p1.height > p2.height) return -1;
            if (p1.weight < p2.weight && p1.height < p2.height) return +1;
            return 0;
        });
        System.out.println(Arrays.toString(A));
        int rank = 1;
        A[0].rank = 1;
        for (int i = 1; i < N; ++i) {
            if (A[i-1].weight > A[i].weight && A[i-1].height > A[i].height) rank = i+1;;
            A[i].rank = rank;
        }
        Arrays.sort(A, (p1, p2) -> p1.index - p2.index);
        StringBuilder builder = new StringBuilder();
        for (Person p : A)
            builder.append(p.rank).append(' ');
        System.out.println(builder.toString().trim());
    }
}
