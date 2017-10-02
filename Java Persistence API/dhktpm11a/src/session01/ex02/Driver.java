package session01.ex02;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Driver {
	public static void main(String[] args) throws Exception{
		String url="http://localhost/hello/a.zip";
		Callable<Long> dlc=new DownloadCallable(url, "d:/a/x.zip");
		FutureTask<Long>ft=new FutureTask<>(dlc);
		Thread t=new Thread(ft);
		t.start();
		long kq=ft.get();
		System.out.println("download duoc "+kq+" bytes");
		
	}
}
