package day1227;

public class Ex4Thread extends Thread {
	
	String msg;
	int cnt;
	
	public Ex4Thread(String msg, int cnt) {
		this.msg = msg;
		this.cnt = cnt;
	}
	
	public static void main(String[] args) {
		
		Ex4Thread ex1 = new Ex4Thread("1번 쓰레드", 300);
		Ex4Thread ex2 = new Ex4Thread("2번 쓰레드", 300);
		Ex4Thread ex3 = new Ex4Thread("3번 쓰레드", 300);
		
		ex1.start();
		ex2.start();
		ex3.start();
		
	}
	
}
