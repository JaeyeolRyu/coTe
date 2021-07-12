package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
 
public class Client {

	private Socket clientSocket;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void connect() {
		try {
			System.out.println("접속시도중");
			System.out.println("Linux에서도 접속한다");
			clientSocket = new Socket("192.168.164.129", 10002);
			System.out.println("접속완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String dataRecv() {
		
		try {
			return dataInputStream.readUTF();
		} catch (Exception e) {
		}
		return null;
	}
	
	public void dataSend(String sendData) {
		
		try {
			dataOutputStream.writeUTF(sendData);
		} catch (Exception e) {
		}
		
	}
	
	public void streamSetting() {
		
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void closeAll() {
		try {
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();
		} catch (IOException e) {
		}
	}
	
	public Client() {
		connect();
		streamSetting();
		dataSend("안녕하세요 클라이언트입니다^^");
		System.out.println(dataRecv());
	}
	
	
	public static void main(String[] args) {
		new Client();
	}

}
