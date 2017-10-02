package session01.ex01.thread;

public class Drive {

	public static void main(String[] args) {
		//bước 2:Tạo các Thread từ các task
		Runnable r1=new TaskA("Collect Data",100);
		TaskB r2=new TaskB("Process Data",100);
		
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		
		t2.setPriority(Thread.MAX_PRIORITY);
		
		//bước 3: Cho thực thi bằng cách start các Thread
		t1.start();
		t2.start();
	}

}
