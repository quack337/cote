package baekjoon.b1504.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    static int 탐색(int 시작정점, int 목표정점) throws Exception {
        boolean[] 방문함 = new boolean[정점목록.length];
        PriorityQueue<Vertex> 방문할정점목록 = new PriorityQueue<>();
        방문할정점목록.add(new Vertex(시작정점, 0));
        while (방문할정점목록.size() > 0) {
            Vertex v = 방문할정점목록.remove();
            if (v.정점 == 목표정점) return v.거리;
            if (방문함[v.정점]) continue;
            방문함[v.정점] = true;
            for (Edge e : 정점목록[v.정점])
                if (방문함[e.정점] == false)
                    방문할정점목록.add(new Vertex(e.정점, e.가중치 + v.거리));
        }
        throw new Exception();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int 정점수 = Integer.parseInt(tokenizer.nextToken());
        int 간선수 = Integer.parseInt(tokenizer.nextToken());
        정점목록 = new ArrayList[정점수];
        for (int i = 0; i < 정점수; ++i)
            정점목록[i] = new ArrayList<>();
        for (int i = 0; i < 간선수; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int 정점1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int 정점2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int 가중치 = Integer.parseInt(tokenizer.nextToken());
            정점목록[정점1].add(new Edge(가중치, 정점2));
            정점목록[정점2].add(new Edge(가중치, 정점1));
        }
        tokenizer = new StringTokenizer(reader.readLine());
        int 경유정점1 = Integer.parseInt(tokenizer.nextToken()) - 1;
        int 경유정점2 = Integer.parseInt(tokenizer.nextToken()) - 1;

        int 거리1 = Integer.MAX_VALUE, 거리2 = Integer.MAX_VALUE;
        try {
            거리1 = 탐색(0, 경유정점1) + 탐색(경유정점1, 경유정점2) + 탐색(경유정점2, 정점수-1);
        } catch (Exception e) { }
        try {
            거리2 = 탐색(0, 경유정점2) + 탐색(경유정점2, 경유정점1) + 탐색(경유정점1, 정점수-1);
        } catch (Exception e) { }
        if (거리1 ==  Integer.MAX_VALUE && 거리2 ==  Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(거리1, 거리2));
    }
}