import java.util.ArrayList;

class JavaStack<T> extends ArrayList{
	public boolean push (T data) {
		return add(data);
	}

	public T pop() {
		return (T)(remove(size() - 1));
	}

	public static void main(String[] args) {
		JavaStack smallStack = new JavaStack();

		smallStack.push(new Double(2.1));
		smallStack.push(new Double(6.0));

		System.out.println(smallStack.get(0));
	}
}
/*
	private T[] values = new T[5];

	private int top = 0;

	public boolean isEmpty() {
		return top <= 0;
	}

	public T pop(){
		return values[--top];
	}

	public void push(T i) {
		values[top++] = i;
	}

	public void remove(int i) {
		while (i > 0) {
			pop();
			i--;
		}
	}
*/