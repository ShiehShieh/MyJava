public class JavaHome{
	public static void main(String[] args) {
	}
}

abstract class Student{
	private String fristName = " ", lastName = " ";
	private int id = 0;
	abstract public void setValue(String frist, String last, int i);
	abstract public int returnId();
	abstract public String returnName();
}
