package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(8888);
		Socket client=null;
		while(true){
			client=serverSocket.accept();
			new ServerThread(client).start();
		}
//		serverSocket.close();
	}

}
