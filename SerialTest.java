import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;

class Parent implements Serializable {
	int parentVersion = 10;
}

class Contain implements Serializable {
	int containVersion = 11;
}

class SerialTest extends Parent implements Serializable {
	int version = 66;
	Contain con = new Contain();

	public int getVersion() {
		return version;
	}

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		SerialTest st = new SerialTest();
		oos.writeObject(st);
		oos.flush();
		oos.close();
	}
}
