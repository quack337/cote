package line.e2019;

public class Example02 {

    static class Node {
        int value;
        Node prev, next;

        public Node() {
        }

        public Node(int value, Node prev, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    static class DoubleLinkedList {
        Node dummy;

        public DoubleLinkedList() {
            dummy = new Node();
            dummy.prev = dummy;
            dummy.next = dummy;
        }

        public void addHead(int value) {
            Node node = new Node(value, dummy, dummy.next);
            dummy.next.prev = node;
            dummy.next = node;
        }

        public void removeTail() {
            Node tail = dummy.prev;
            if (tail == dummy) return;
            tail.prev.next = dummy;
            dummy.prev = tail.prev;
        }

        public void print() {
            Node node = dummy.next;
            while (node != dummy) {
                System.out.printf("%d ", node.value);
                node = node.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        for (int i = 0; i < 10; ++i)
            list.addHead(i);
        list.print();

        for (int i = 0; i < 10; ++i) {
            list.removeTail();
            list.print();
        }
    }

}
