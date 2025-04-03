package nhn.e1a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class GeometryUtils {
    public static double distance(int x1, int y1, int x2, int y2) { // 두 좌표 사이 거리 계산
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

class Node {
    int id, x, y, r; // 노드ID, 원 중심 x좌표, 원 중심 y좌표, 반지름
    boolean visited; // 방문한 노드인가?
    Node parent;     // 부모 노드
    List<Node> children = new ArrayList<Node>(); // 자식 노드

    public Node(int id, int x, int y, int r) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean overlaps(Node c) { // this가 c와 겹치는가?
        return GeometryUtils.distance(x, y, c.x, c.y) <= (r + c.r);
    }

    public boolean contains(Node c) { // this가 c를 포함하는가?
        return GeometryUtils.distance(x, y, c.x, c.y) < Math.abs(r - c.r);
    }

    public boolean addChild(Node c) throws Exception { // 자식 노드 추가
        if (this.contains(c) == false) {
            if (this.overlaps(c))
                throw new Exception(String.format("겹침 %d, %d", this.id, c.id));
            return false;
        }
        for (Node child : this.children)
            if (child.addChild(c))
                return true;
        this.children.add(c);
        c.parent = this;
        return true;
    }
}

public class Quiz {

    static class InputParam { // 입력 값
        Node[] a;
        int startNodeId, endNodeId;
    }

    static InputParam getInputParam() { // 입력 값 리턴
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("입력?");
            InputParam param = new InputParam();
            int count = scanner.nextInt();
            param.a = new Node[count];
            for (int i = 0; i < count; ++i) {
                int id = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int r = scanner.nextInt();
                scanner.nextLine();
                param.a[i] = new Node(id, x, y, r);
            }
            param.startNodeId = scanner.nextInt();
            param.endNodeId = scanner.nextInt();
            return param;
        }
    }

    static Node findNodeById(Node[] a, int id) { // id 값으로 Node 찾기
        for (Node c : a)
            if (c.id == id)
                return c;
        return null;
    }

    // 탐색 트리 생성
    static Node createSearhTree(Node[] a) throws Exception {
        Arrays.sort(a, (c1, c2) -> c2.r - c1.r); // 반지름 크기 역순으로 정렬
        Node root = new Node(0, 5000, 5000, 20000); // 0번 root node 생성
        for (Node c : a)
            root.addChild(c);
        return root;
    }

    // 탐색 메소드#1: startNode에서 endNode까지 경로 찾기
    static boolean searchPath(Node startNode, int endNodeId, List<Node> resultPath) {
        while (startNode != null) {
            // 먼저 현재 노드의 서브 트리에서 목적지를 찾는다
            if (searchSubtree(startNode, endNodeId, resultPath)) return true; // 경로를 찾았으면 리턴
            startNode.visited = true;     // 현재 노드로부터 목적지까지 경로를 찾을 수 없다면,
            resultPath.add(startNode);    // 현재 노드를 방문한 노드로 표시하고
            startNode = startNode.parent; // 현재 노드의 부모 노드에서 찾기를 반복한다
        }
        return false;
    }

    // 탐색 메소드 #2: 주어진 노드의 서브 트리에서 endNode를 찾는다
    static boolean searchSubtree(Node node, int endNodeId, List<Node> resultPath) {
        resultPath.add(node);
        if (node.id == endNodeId) return true; // 현재 노드가 목적지 노드라면 리턴
        for (Node c : node.children)           // 자식 노드 각각에 대해서, 찾기 재귀호출
            if (!c.visited && searchSubtree(c, endNodeId, resultPath))
                return true;                   // 찾았으면 리턴
        resultPath.remove(resultPath.size() - 1); // 못찾았으면, 경로에서 현재 노드 제거
        return false;
    }

    static void printPath(List<Node> path) { // 경로 출력하기
        for (Node c : path)
            System.out.printf("%d ", c.id);
    }

    public static void main(String[] args) {
        try {
            InputParam inputParam = getInputParam();

            Node root = createSearhTree(inputParam.a);
            Node startNode = (inputParam.startNodeId == 0) ? root : findNodeById(inputParam.a, inputParam.startNodeId);
            List<Node> resultPath = new ArrayList<Node>();
            boolean r = searchPath(startNode, inputParam.endNodeId, resultPath);
            if (r) printPath(resultPath);
            else System.out.println("-1");

        } catch (Exception e) {
            System.out.println("-1");
            System.err.println(e.getMessage());
        }
    }

}