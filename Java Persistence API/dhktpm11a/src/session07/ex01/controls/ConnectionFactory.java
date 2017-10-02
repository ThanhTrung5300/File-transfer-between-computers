package session07.ex01.controls;

import java.sql.Connection;
import java.sql.DriverManager;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectionFactory {
	private static ConnectionFactory factory;
	private Connection con;
	
	private ConnectionFactory() throws Exception{
		Class.forName(SQLServerDriver.class.getName());
		String url="jdbc:sqlserver://localhost:1433;databaseName=qlsv";
		con=DriverManager.getConnection(url,"sa","12345678");
	}
	
	public synchronized static ConnectionFactory getInstance() 
			throws Exception {
		if(factory==null)
			factory=new ConnectionFactory();
		return factory;
	}

	public Connection getConnection() {
		return con;
	}
	
	public void close()throws Exception{
		if(con!=null)
			con.close();
	}
	
	
}
