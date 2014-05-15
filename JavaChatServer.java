import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.io.*;


class MyServer {
	private String host;
	private int port;
	private ServerSocket server;
	MyServer() throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Host :");
		this.host = stdin.readLine();
		System.out.println("Port :");
		this.port = Integer.parseInt(stdin.readLine());

		this.server = new ServerSocket();
	}
	void run() throws IOException {
		System.out.println("Binding...");
		this.server.bind(new InetSocketAddress(host, port));

		Socket client = this.server.accept();

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
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


public class JavaChatServer {
	public static void main(String[] args) throws IOException{
		MyServer myServer = new MyServer();

		myServer.run();
	}
}
