import java.io.*;

class Cube {
	public void run() throws IOException{
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a :");
		int a = Integer.parseInt(stdIn.readLine());
		System.out.print("b :");
		int b = Integer.parseInt(stdIn.readLine());
		System.out.print("c :");
		int c = Integer.parseInt(stdIn.readLine());

		System.out.format("The volume :%d\n", a * b * c);
		System.out.format("The surface area :%d\n", (a * b) * 2 + (c * a) * 2 + (b * c) * 2);
	}

	public static void main(String[] args) throws IOException{
		Cube cube = new Cube();
		cube.run();
	}
}