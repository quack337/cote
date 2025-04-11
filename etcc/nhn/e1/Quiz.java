package etcc.nhn.e1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class GeometryUtils {
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

class Circle {
    int id, x, y, r;
    List<Circle> children = new ArrayList<Circle>();
    Circle parent;

    public Circle(int id, int x, int y, int r) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean overlaps(Circle c) {
        return GeometryUtils.distance(x, y, c.x, c.y) <= (r + c.r);
    }

    public boolean contains(Circle c) {
        return GeometryUtils.distance(x, y, c.x, c.y) < Math.abs(r - c.r);
    }

    public boolean addChild(Circle c) throws Exception {
        if (this.contains(c) == false) {
            if (this.overlaps(c))
                throw new Exception(String.format("겹침 %d, %d", this.id, c.id));
            return false;
        }
        for (Circle child : this.children)
            if (child.addChild(c))
                return true;
        this.children.add(c);
        c.parent = this;
        return true;
    }
}

public class Quiz {

    static class InputParam {
        Circle[] a;
        int start, end;
    }

    static InputParam getInputParam() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputParam param = new InputParam();
            int count = scanner.nextInt();
            param.a = new Circle[count];
            for (int i = 0; i < count; ++i) {
                int id = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int r = scanner.nextInt();
                scanner.nextLine();
                param.a[i] = new Circle(id, x, y, r);
            }
            param.start = scanner.nextInt();
            param.end = scanner.nextInt();
            return param;
        }
    }

    static Circle findNodeById(Circle[] a, int id) {
        for (Circle c : a)
            if (c.id == id)
                return c;
        return null;
    }

    static boolean searchPath(Circle node, int endNodeId, List<Circle> path) {
        if (searchChildren(node, endNodeId, path)) return true;

        while (node.parent != null) {
            path.add(node);
            if (searchFromParent(node, endNodeId, path)) return true;
            node = node.parent;
        }
        return false;
    }

    static boolean searchChildren(Circle node, int endNodeId, List<Circle> path) {
        path.add(node);
        if (node.id == endNodeId) return true;
        for (Circle c : node.children)
            if (searchChildren(c, endNodeId, path))
                return true;
        path.remove(path.size() - 1);
        return false;
    }

    static boolean searchFromParent(Circle node, int endNodeId, List<Circle> path) {
        Circle parent = node.parent;
        path.add(parent);
        if (parent.id == endNodeId) return true;
        for (Circle c : parent.children)
            if (c != node && searchChildren(c, endNodeId, path))
                return true;
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        try {
            int startNodeId = 6, endNodeId = 11;
            Circle[] a = { new Circle(1, 10, 10, 7), new Circle(2, 50, 10, 7), new Circle(3, 10, 50, 5),
                           new Circle(4, 50, 50, 5), new Circle(5, 30, 32, 20), new Circle(6, 34, 24, 4),
                           new Circle(7, 30, 74, 20), new Circle(8, 24, 77, 10), new Circle(9, 29, 77, 3),
                           new Circle(10, 42, 77, 7), new Circle(11, 44, 77, 3) };
            Arrays.sort(a, (c1, c2) -> c2.r - c1.r);

            Circle root = new Circle(0, 5000, 5000, 10000);

            for (Circle c : a)
                root.addChild(c);

            Circle startNode = findNodeById(a, startNodeId);

            List<Circle> path = new ArrayList<Circle>();
            boolean r = searchPath(startNode, endNodeId, path);

            for (Circle c : path) {
                System.out.println(c.id);
            }
            System.out.println(r);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // todo: delete
    static void print(Circle[] a) {
        for (Circle c : a)
            System.out.printf("%d, %d\n", c.id, c.r);
    }


}