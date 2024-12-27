package day1227;

public class Ex5Runnable implements Runnable {

	int count;
	String msg;
	
	public Ex5Runnable(String msg,int count) {
		this.msg = msg;
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int i = 1;i <= count; i++) {
			System.out.println(msg+":" + i);
		}
	}
	
	public static void main(String[] args) {
		Ex5Runnable ex1=new Ex5Runnable("1번 쓰레드", 300);
		Ex5Runnable ex2=new Ex5Runnable("2번 쓰레드", 300);
		Ex5Runnable ex3=new Ex5Runnable("3번 쓰레드", 300);
		
		Thread th1=new Thread(ex1);
		Thread th2=new Thread(ex2);
		Thread th3=new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();
		
	}

}
