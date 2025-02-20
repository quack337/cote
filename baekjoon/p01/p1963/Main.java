package baekjoon.p01.p1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> getPrimeNumbers(int min, int max) {
        boolean[] prime = new boolean[max + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; (i * i) <= max; ++i)
            if (prime[i]) {
                for(int j = i * 2; j <= max; j += i)
                    prime[j] = false;

            }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; ++i)
            if (prime[i]) result.add(i);
        return result;
    }

    static List<Integer> primeNumbers = getPrimeNumbers(1000, 9999);

    static int distance(int a, int b) {
        int count = 0;
        while (a > 0) {
            if (a % 10 != b % 10) ++count;
            a /= 10;
            b /= 10;
        }
        return count;
    }

    static List<Integer> getNextNumbers(int value, Set<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i : numbers)
            if (distance(i, value) == 1)
                result.add(i);
        return result;
    }

    static class Node {
        int value, distance;

        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }

    static int BFS(int start, int end) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.addAll(primeNumbers);
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int value = node.value, distance = node.distance;
            if (value == end) return distance;
            numbers.remove(value);
            List<Integer> nextNumbers = getNextNumbers(value, numbers);
            for (int i : nextNumbers)
                queue.add(new Node(i, distance + 1));
        }
        return -1;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            System.out.println(BFS(start, end));
        }
    }
}
