package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverz {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket=new ServerSocket(8888);
		Socket client=serverSocket.accept();
		System.out.println("һ���ͻ��˽�������");
		String msg=new String("��ӭʹ��");
//		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		bufferedWriter.write(msg);
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}

}
