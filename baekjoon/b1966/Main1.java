package baekjoon.b1966;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static class Document {
        int no, priority;

        public Document(int no, int priority) {
            this.no = no;
            this.priority = priority;
        }
    }

    static void swap(Document[] a, int i, int j) {
        Document temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int partition(Document[] a, int start, int end) {
        swap(a, (start + end) / 2, end);
        Document value = a[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; ++j)
            if (a[j].priority > value.priority)
                swap(a, ++i, j);
        swap(a, i + 1, end);
        return i + 1;
    }

    static Document quickSelect(Document[] a, int start, int end, int nth) {
        if (start >= end) return a[start];
        int middle = partition(a, start, end);
        int middle_nth = middle - start + 1;
        if (nth == middle_nth) return a[middle];
        if (nth < middle_nth)
            return quickSelect(a, start, middle-1, nth);
        else
            return quickSelect(a, middle+1, end, nth - middle_nth);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            Document[] A = new Document[N];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < N; ++i) {
                int priority = Integer.parseInt(tokenizer.nextToken());
                A[i] = new Document(i + 1, priority);
            }
            System.out.println(quickSelect(A, 0, A.length-1, M).no);
        }
    }
}