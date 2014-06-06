package lecture3;

public class Stack {
	private int[] values = new int[5];
	private int top = 0;
	public boolean isEmpty() {
		return top <= 0; }
	public int pop(){
		return values[--top]; }
	public void push(int i) {
		values[top++] = i; }
	public void remove(int i) {
		while (i > 0) {
				pop();
				i--;}
	}
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(3);
		s.remove(3);
	}

}
