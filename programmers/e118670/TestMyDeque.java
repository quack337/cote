public class TestMyDeque {

    @SuppressWarnings("unchecked")
    static class MyDeque<T> {
        Object[] data = new Object[16];
        int begin = 0, count = 0;

        void expand() throws Exception {
            Object[] temp = new Object[data.length * 2];
            for (int i = 0; i < count; ++i)
                temp[i] = get(i);
            data = temp;
            begin = 0;
        }

        public void addFirst(T value) throws Exception {
            if (count == data.length) expand();
            --begin;
            if (begin == -1) begin = data.length - 1;
            data[begin] = value;
            ++count;
        }

        public T removeFirst() throws Exception {
            if (count == 0) throw new Exception();
            T value = (T)data[begin];
            ++begin;
            if (begin == data.length) begin = 0;
            --count;
            return value;
        }

        public void addLast(T value) throws Exception {
            if (count == data.length) expand();
            int index = (begin + count) % data.length;;
            data[index] = value;
           ++count;
        }

        public T removeLast() throws Exception {
            if (count == 0) throw new Exception();
            int index = (begin + count) % data.length;;
            T value = (T)data[index];
            --count;
            return value;
        }

        public T get(int index) throws Exception {
            if (index >= count) throw new Exception();
            index = (index + begin) % data.length;
            return (T)data[index];
        }
    }

    static void print(MyDeque<Integer> deq) throws Exception {
        for (int i = 0; i < deq.count; ++i)
            System.out.printf("%d ", deq.get(i));
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        MyDeque<Integer> deq = new MyDeque<>();
        for (int i = 0; i < 5; ++i)
            deq.addLast(i);
        print(deq);

        for (int i = 0; i < 5; ++i)
            deq.addFirst(i);
        print(deq);

        for (int i = 0; i < 2; ++i)
            deq.removeLast();
        print(deq);

        for (int i = 0; i < 2; ++i)
            deq.removeFirst();
        print(deq);
    }
}