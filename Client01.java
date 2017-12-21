package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client01 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost", 8888);
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		String str="client-01";
		bufferedWriter.write(str);
		bufferedWriter.newLine();
		bufferedWriter.flush();
		String echo=bufferedReader.readLine();
		System.out.println(echo);
		if(client!=null){
			client.close();
		}
	}
}
