package etcc.line.e2019;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

class MyList<V extends Comparable<V>> {
    ArrayDeque<V> queue = new ArrayDeque<>();

    V min() {
       if (queue.size() == 0)
          throw new IllegalStateException();
       V min = queue.getFirst();
       for (V e : queue)
          if (e.compareTo(min) < 0)
             min = e;
       return min;
    }

    void add(V value) {
       queue.add(value);
    }

    V remove() {
       if (queue.size() == 0)
          throw new IllegalStateException();
       V value = queue.getFirst();
       queue.remove();
       return value;
    }

    void print() {
       System.out.println("print");
       for(V e : queue) {
          System.out.println(e);
       }
    }
 }

 public class Example01 {

    public static void main(String[] args) throws IOException {
       MyList<Integer> list = new MyList<>();
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