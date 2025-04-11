package etcc.net.skhu.mine1;
import java.util.Arrays;

public class MyStack<T> {
	static final int INITIAL_SIZE = 10;
	static final double GROWTH_RATE = 2.0;

	Object[] data;
	int count;

	public MyStack() {
		data = new Object[INITIAL_SIZE];
		count = 0;
	}

	public boolean isFull() {
		return data.length == count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public void expand() {
		data = Arrays.copyOf(data, (int)(data.length * GROWTH_RATE));
	}

	public void push(T value) {
		if (isFull()) expand();
		data[count] = value;
		++count;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws Exception {
		if (isEmpty()) throw new Exception("stack empty");
		--count;
		return (T)data[count];
	}

	@SuppressWarnings("unchecked")
	public T top() throws Exception {
		if (isEmpty()) throw new Exception("stack empty");
		return (T)data[count - 1];
	}

}