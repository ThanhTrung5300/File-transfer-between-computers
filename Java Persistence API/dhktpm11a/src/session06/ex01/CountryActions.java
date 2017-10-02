package session06.ex01;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.FindIterable;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class CountryActions {
	private MongoCollection<Document> collection;
	
	
	public CountryActions(MongoCollection<Document> collection) {
		this.collection = collection;
	}
	/**
	 * Lấy danh sách tất cả các quốc gia
	 * KHÔNG NÊN LÀM?????
	 * @return
	 * @throws InterruptedException 
	 */
	public Vector<Country> getAllCountries() throws InterruptedException {
		//using for blocking-method
		CountDownLatch latch=new CountDownLatch(1);
		Vector<Country> v=new Vector<>();
		//lấy hết
		FindIterable<Document> fi= collection.find();
		fi.forEach(new Block<Document>() {
			public void apply(Document t) {
				//if(t.containsKey("Name")) ???????
				String name = t.get("Name").toString();
				String code = t.get("Code").toString();
				String capital = t.get("Capital").toString();
				String province = t.get("Province").toString();
				
				String x = t.get("Area").toString();
				double y=-1;
				try{y = Double.parseDouble(x);}catch(Exception ex) {y=-1;};
				
				Double area= y;
				Integer population=t.getInteger("Population");
				Country c=new Country(name, code, capital, province, area, population);
				v.add(c);
			}
		}, new SingleResultCallback<Void>() {
			public void onResult(Void result, Throwable t) {
				if(t!=null)
					System.out.println("*******"+t.getMessage());
				latch.countDown();
			}
		});
		latch.await();//chờ cho đến khi nào xong thì thôi
		return v;
	}

	private Country country=null;
	public Country getCountryByCode(String code) throws InterruptedException {
		//using for blocking-method
		CountDownLatch latch=new CountDownLatch(1);
		//lấy hết
		FindIterable<Document> fi= collection.find(Filters.eq("Code",code));
		fi.first(new SingleResultCallback<Document>() {
			@Override
			public void onResult(Document result, Throwable t) {
				if(result!=null) {
					//if(t.containsKey("Name")) ???????
					String name = result.get("Name").toString();
					String code = result.get("Code").toString();
					String capital = result.get("Capital").toString();
					String province = result.get("Province").toString();
					
					String x = result.get("Area").toString();
					double y=-1;
					try{y = Double.parseDouble(x);}catch(Exception ex) {y=-1;};
					
					Double area= y;
					Integer population=result.getInteger("Population");
					country=new Country(name, code, capital, province, area, population);
				}
				latch.countDown();
			}
		});
		latch.await();//chờ cho đến khi nào xong thì thôi
		return country;
	}

}
