package session02.ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolingDemo {
	public static void main(String[] args) throws Exception{
		YourTask yt1=new YourTask("fooo", 5);
		YourTask yt2=new YourTask("baar", 20);
		YourTask yt3=new YourTask("sot", 6);
		
		ExecutorService exe=Executors.newFixedThreadPool(2);
		exe.execute(yt1);
		exe.execute(yt2);
		exe.execute(yt3);
	
		exe.shutdown();
	}
}
