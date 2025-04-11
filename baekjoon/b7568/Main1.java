package baekjoon.b7568;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {

    static class Person implements Comparable<Person> {
        int weight, height, rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Person p) {
            int r1 = p.height - this.height;
            int r2 = p.weight - this.weight;
            if (r1 >= 0 && r2 >= 0 || r1 <= 0 && r2 <= 0)
                return r1 + r2;
            return 0;
        }
    }

    static void print(int N, Person[] A) {
        System.out.println();
        for (int i = 0; i < N; ++i)
            System.out.printf("%d %d %d\n", A[i].weight, A[i].height, A[i].rank);
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        Person[] A = new Person[N];
        for (int i = 0; i < N; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());
            A[i] = new Person(w, h);
        }
        Person[] B = Arrays.copyOf(A, N);
        Arrays.sort(B);
        int rank = 1;
        B[0].rank = rank;
        for (int i = 1; i < N; ++i) {
            if (B[i].compareTo(B[i - 1]) > 0)
                rank = i + 1;
            B[i].rank = rank;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; ++i)
            builder.append(A[i].rank).append(' ');
        System.out.println(builder.toString());
    }
}