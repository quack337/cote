package baekjoon.b1753.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int 가중치, 정점;

    public Edge(int 가중치, int 정점) {
        this.가중치 = 가중치;
        this.정점 = 정점;
    }
}

class Vertex implements Comparable<Vertex> {
    int 정점, 거리;

    public Vertex(int 정점, int 거리) {
        this.정점 = 정점;
        this.거리 = 거리;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return this.거리 - vertex.거리;
    }
}

@SuppressWarnings("unchecked")
public class Main {
    static List<Edge>[] 정점목록;
    static boolean[] 방문함;
    static int[] 최단거리;

    static void 탐색(int 시작정점) {
        PriorityQueue<Vertex> 방문할정점목록 = new PriorityQueue<>();
        방문할정점목록.add(new Vertex(시작정점, 0));
        while (방문할정점목록.size() > 0) {
            Vertex v = 방문할정점목록.remove();
            if (최단거리[v.정점] > v.거리) 최단거리[v.정점] = v.거리;
            if (방문함[v.정점]) continue;
            방문함[v.정점] = true;
            for (Edge e : 정점목록[v.정점])
                if (방문함[e.정점] == false)
                    방문할정점목록.add(new Vertex(e.정점, e.가중치 + v.거리));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int 정점수 = Integer.parseInt(tokenizer.nextToken());
        int 간선수 = Integer.parseInt(tokenizer.nextToken());
        int 시작정점 = Integer.parseInt(reader.readLine()) - 1;
        정점목록 = new ArrayList[정점수];
        for (int i = 0; i < 정점수; ++i)
            정점목록[i] = new ArrayList<>();
        방문함 = new boolean[정점수];
        최단거리 = new int[정점수];
        Arrays.fill(최단거리, Integer.MAX_VALUE);
        for (int i = 0; i < 간선수; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int 정점1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int 정점2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int 가중치 = Integer.parseInt(tokenizer.nextToken());
            정점목록[정점1].add(new Edge(가중치, 정점2));
        }
        탐색(시작정점);
        for (int i = 0; i < 정점수; ++i)
            if (최단거리[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(최단거리[i]);
    }
}