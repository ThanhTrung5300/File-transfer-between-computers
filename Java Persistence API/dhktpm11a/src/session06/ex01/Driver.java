package session06.ex01;

import org.bson.Document;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class Driver {

	public static void main(String[] args) throws Exception{
		ConnectMongoDbFactory factory = ConnectMongoDbFactory.getInstance();
		MongoClient client = factory.getMongoClient();
		
		DatabaseUtils util = new DatabaseUtils(client);
		
		MongoDatabase db = util.getDatabaseByName("mondial");
		MongoCollection<Document> col = util.getCollectionByName(db, "countries");
		
		CountryActions ca=new CountryActions(col);
		/*Vector<Country> countries = ca.getAllCountries();
		for(Country c:countries) {
			System.out.println(c);
		}*/
		Country c = ca.getCountryByCode("VN");
		System.out.println(c);
		
		client.close();
	}

}
