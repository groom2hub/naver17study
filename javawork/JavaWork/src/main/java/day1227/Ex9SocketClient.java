package day1227;

import java.io.IOException;
import java.net.Socket;

public class Ex9SocketClient {
	
	public static void main(String[] args) {
		
//		String ip = "127.0.0.1";
		String ip = "192.168.0.1";
		Socket socket = null;
		
		try {
			socket = new Socket(ip, 6000);
			System.out.println("서버에 접속 성공");
		} catch (IOException e) {
			System.out.println("서버에 접속 실패: " + e.getMessage());
		}
		
	}

}