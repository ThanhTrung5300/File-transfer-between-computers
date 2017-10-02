package session06.ex01;

import org.bson.Document;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.async.client.MongoDatabase;

public class DatabaseUtils {
	private MongoClient client;
	public DatabaseUtils(MongoClient client) {
		this.client=client;
	}
	public MongoDatabase getDatabaseByName(String dbname) {
		return client.getDatabase(dbname);
	}
	
	public MongoCollection<Document>getCollectionByName(
			MongoDatabase db,String colName
			){
		return db.getCollection(colName);
	}
}
