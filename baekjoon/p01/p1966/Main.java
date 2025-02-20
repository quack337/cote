package baekjoon.p01.p1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static class Document {
        int no, priority;

        public Document(int no, int priority) {
            this.no = no;
            this.priority = priority;
        }
    }

    static int maxPriority(ArrayDeque<Document> queue) {
        int max = 0;
        for (Document doc : queue)
            if (max < doc.priority) max = doc.priority;
        return max;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            ArrayDeque<Document> queue = new ArrayDeque<>();
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i) {
                int priority = Integer.parseInt(tokenizer.nextToken());
                queue.addLast(new Document(i, priority));
            }
            int count = 0;
            while (true) {
                Document doc = queue.removeFirst();
                int max = maxPriority(queue);
                if (doc.priority < max) queue.addLast(doc);
                else {
                    ++count;
                    if (doc.no == M) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
