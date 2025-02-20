package programmers.e42583.list;

public class LinkedList {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node dummy;
    int size;

    public LinkedList() {
        dummy = new Node(Integer.MIN_VALUE);
        dummy.prev = dummy.next = dummy;
        size = 0;
    }

    // node 뒤에 value 노드를 추가한다.
    public void addAfter(Node node, int value) {
        Node newNode = new Node(value);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        ++size;
    }

    // node 앞에 value 노드를 추가한다.
    public void addBefore(Node node, int value) {
        Node newNode = new Node(value);
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
        ++size;
    }

    // 선두에 value 노드를 추가한다.
    public void addHead(int value) {
        addAfter(dummy, value);
    }

    // 후미에 value 노드를 추가한다.
    public void addTail(int value) {
        addBefore(dummy, value);
    }

    // node를 제거한다.
    public void remove(Node node) {
        if (size == 0) return;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        --size;
    }

    // 길이를 리턴한다.
    public int size() {
        return size;
    }

    // head 노드를 리턴한다.
    // 길이가 0 이면 null을 리턴한다.
    public Node head() {
        if (size == 0) return null;
        return dummy.next;
    }

    // tail 노드를 리턴한다.
    // 길이가 0 이면 null을 리턴한다.
    public Node tail() {
        if (size == 0) return null;
        return dummy.prev;
    }

    // 뒤 노드를 리턴한다.
    // 뒤 노드가 없으면 null을 리턴한다.
    public Node next(Node node) {
        node = node.next;
        return node == dummy ? null : node;
    }

    // 앞 노드를 리턴한다.
    // 앞 노드가 없으면 null을 리턴한다.
    public Node prev(Node node) {
        node = node.prev;
        return node == dummy ? null : node;
    }

}
