package session01.ex02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Callable;

public class DownloadCallable implements Callable<Long>{
	
	private String url;
	private String destinationURL;
	
	public DownloadCallable(String url, String destinationURL) {
		this.url = url;
		this.destinationURL = destinationURL;
	}



	@Override
	public Long call() throws Exception {
		long bytes=0;
		URL x=new URL(url);
		InputStream is = x.openStream();
		byte[] buff=new byte[512];
		int len=0;
		
		FileOutputStream fos=new FileOutputStream(destinationURL);
		
		while((len=is.read(buff))!=-1) {
			fos.write(buff,0,len);
			bytes+=len;
			System.out.println(bytes);
		}
		fos.flush();
		fos.close();
		is.close();
		return bytes;
	}

}
