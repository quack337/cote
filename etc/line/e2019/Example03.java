package net.skhu.line.e2019;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

class MyList3<V extends Comparable<V>> {

    static class Node {
        Object value;
        Node prev, next;

        public Node() {
        }

        public Node(Object value, Node prev, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    Node dummy;

    public MyList3() {
        dummy = new Node();
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    private void addHead(V value) {
        Node node = new Node(value, dummy, dummy.next);
        dummy.next.prev = node;
        dummy.next = node;
    }

    private void removeTail() {
        Node tail = dummy.prev;
        if (tail == dummy) return;
        tail.prev.next = dummy;
        dummy.prev = tail.prev;
    }

    private Object getTail() {
        return dummy.prev.value;
    }

    private void printList() {
        Node node = dummy.next;
        while (node != dummy) {
            System.out.println(node.value);
            node = node.next;
        }
    }


    TreeMap<V, Node> map = new TreeMap<>();

    V min() {
       if (map.size() == 0)
          throw new IllegalStateException();
       return map.firstKey();
    }

    void add(V value) {
       addHead(value);
       map.put(value, dummy.next);
    }

    V remove() {
       if (map.size() == 0)
          throw new IllegalStateException();
       V value = (V)getTail();
       removeTail();
       map.remove(value);
       return value;
    }

    void print() {
       System.out.println("print");
       printList();
    }
 }

 public class Example03 {

    public static void main(String[] args) throws IOException {
        MyList3<Integer> list = new MyList3<>();
       try (Scanner scanner = new Scanner(System.in)) {
          while (true) {
             String cmd = scanner.next();
             try {
                switch (cmd.toLowerCase()) {
                case "min":
                   System.out.println(list.min());
                   break;
                case "add":
                   list.add(scanner.nextInt());
                   break;
                case "remove":
                   System.out.println(list.remove());
                   break;
                case "exit":
                   list.print();
                   return;
                }
                scanner.nextLine();
             } catch (Exception ex) {
                System.out.println(-1);
             }
          }
       }
    }
}
