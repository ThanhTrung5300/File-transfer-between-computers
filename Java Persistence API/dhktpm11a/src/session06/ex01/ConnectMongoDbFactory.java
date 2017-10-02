package session06.ex01;

import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;

public class ConnectMongoDbFactory {
	private MongoClient mongoClient=null;
	private static ConnectMongoDbFactory conDB=null;
	
	private ConnectMongoDbFactory() {
		//mongoClient=MongoClients.create("mongodb://vvhsvr:27017");
		mongoClient=MongoClients.create("mongodb://localhost:27017");
	}
	public synchronized static ConnectMongoDbFactory getInstance() {
		if(conDB==null)
			conDB=new ConnectMongoDbFactory();
		return conDB;
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	
	public void close() {
		if(mongoClient!=null)
			mongoClient.close();
	}
}
