package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	
	Socket client=null;
	BufferedReader bufferedReader=null;
	BufferedWriter bufferedWriter=null;
	
	public ServerThread(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		System.out.println("和客户端取得连接");
		try {
			bufferedReader=new BufferedReader(new InputStreamReader(client.getInputStream()));
			bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			System.out.println("ÊÕµ½ "+bufferedReader.readLine());
			String msg="echo "+bufferedReader.readLine();
			bufferedWriter.write(msg);
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
