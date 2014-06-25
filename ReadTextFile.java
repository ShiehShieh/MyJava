import java.io.*;

interface Read {
	public void display(String fileName);
}

public class ReadTextFile implements Read{
	public void display(String fileName) {
		try {
			RandomAccessFile input = new RandomAccessFile(fileName, "r");
			String temp            = input.readLine();
			int lines              = 1;
			int count              = temp.length();

			while(temp != null) {
				System.out.println(temp);
				count += temp.length();
				temp = input.readLine();
				++lines;
			}

			System.out.println("Lines :" + lines);
			System.out.println("Charater :" + count);

			input.close();

		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ReadTextFile obj  = new ReadTextFile();
		String fileName   = null;

		try {
			System.out.println("Please Entry The Name Of Your File :");
			fileName = in.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}

		obj.display(fileName);
	}
}
