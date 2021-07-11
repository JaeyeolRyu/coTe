package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;
	private Socket clientSocket;
	
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	
	public void serverSetting() {
		
		try {
			serverSocket = new ServerSocket(10002); // 
			clientSocket = serverSocket.accept();
			System.out.println(" 클라이언트 소켓 연결 ");
			
		} catch (Exception e) {
		}  
		
	}
	
	public void closeAll() {
		try {
			serverSocket.close();
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();
		} catch (Exception e) {
		}
	}
	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
		}
		
	}
	 
	public String dataRecv() {
		
		try {
			return dataInputStream.readUTF();
		} catch (Exception e) {
		}
		return null;
	}
	
	public void sendData(String sendData) {
		try {
			dataOutputStream.writeUTF(sendData);
		} catch (Exception e) {
		}
	}
	
	public Server() {
		serverSetting();
		streamSetting();
		System.out.println(dataRecv());
		sendData("잘받았습니다");
		closeAll();
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
