package chatServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

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

	public void dataRecv() {
		new Thread(new Runnable() {
			boolean isThread = true;

			@Override
			public void run() {
				while (isThread) {
					try {
						String recvData = dataInputStream.readUTF();

						if (recvData.equals("/quit")) {
							isThread = false;
						} else {
							System.out.println(" 상대방 : " + recvData);
						}

					} catch (Exception e) {
					}

				}
			}
		}).start();

	}

	public void dataSend() {
		new Thread(new Runnable() {
			Scanner sc = new Scanner(System.in);

			@Override
			public void run() {
				boolean isThread = true;
				while (isThread) {
					try {

						String sendData = sc.next();
						if (sendData.equals("/quit")) {
							isThread = false;
						} else {
							dataOutputStream.writeUTF(sendData);
						}

					} catch (Exception e) {
					}

				}
			}
		}).start();

	}

	public void streamSetting() {

		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
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
		dataSend();
		dataRecv();
	}

	public static void main(String[] args) {
		new Client();
	}

}
