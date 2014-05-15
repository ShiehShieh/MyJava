import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


class MyServer implements Runnable{
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
	synchronized public void run() {
		try{
			System.out.println("Binding...");
			this.server.bind(new InetSocketAddress(host, port));

			Socket client = this.server.accept();

			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			PrintWriter out = new PrintWriter(client.getOutputStream(), true);

			while(true) {
				String recive = in.readLine();
				System.out.println(recive);

			}
		}catch(IOException error){
			System.out.println(error);
		}

	}
}


class MyClient implements Runnable{
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
	synchronized public void run() {
		try{
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

			}			
		}catch(IOException error){
			System.out.println(error);
		}

	}
}


class OneChat {
	OneChat() {}
	void run() throws IOException {
		MyServer myServer = new MyServer();
		MyClient myClient = new MyClient();
		ExecutorService executor = Executors.newCachedThreadPool();

		executor.execute(myServer);
		executor.execute(myClient);
		executor.shutdown();

	}
}


public class SocketChatFinalProject {
	public static void main(String[] args) throws IOException {
		OneChat oneChat = new OneChat();

		oneChat.run();
	}
}
