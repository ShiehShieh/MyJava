import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.io.*;


class MyClient {
	private String host;
	private int port;
	private Socket client;
	MyClient() throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Host :");
		this.host = stdin.readLine();
		System.out.println("Port :");
		this.port = Integer.parseInt(stdin.readLine());

		this.client = new Socket();
	}
	void run() throws IOException {
		System.out.println("Connecting...");
		this.client.connect(new InetSocketAddress(host, port));

		BufferedReader in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
		PrintWriter out = new PrintWriter(this.client.getOutputStream(), true);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String userInput = stdin.readLine();

			out.println(userInput);

			if (userInput.equals("$QUIT")) {
				break;
			}

			String recive = in.readLine();
			System.out.println(recive);
		}
	}
}


public class JavaChatClient {
	public static void main(String[] args) throws IOException{
		MyClient myClient = new MyClient();

		myClient.run();
	}
}
