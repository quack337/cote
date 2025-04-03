package line.e2019;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.TreeMap;

class MyList2<V extends Comparable<V>> {
    ArrayDeque<V> queue = new ArrayDeque<>();
    TreeMap<V,V> map = new TreeMap<>();

    V min() {
       if (queue.size() == 0)
          throw new IllegalStateException();
       return map.firstKey();
    }

    void add(V value) {
       queue.add(value);
       map.put(value, null);
    }

    V remove() {
       if (queue.size() == 0)
          throw new IllegalStateException();
       V value = queue.getFirst();
       queue.remove();
       map.remove(value);
       return value;
    }

    void print() {
       System.out.println("print");
       for(V e : queue) {
          System.out.println(e);
       }
    }
 }

 public class Example01a {

    public static void main(String[] args) throws IOException {
        MyList2<Integer> list = new MyList2<>();
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