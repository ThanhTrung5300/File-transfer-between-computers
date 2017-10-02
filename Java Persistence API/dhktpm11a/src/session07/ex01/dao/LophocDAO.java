package session07.ex01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import session07.ex01.controls.ConnectionFactory;
import session07.ex01.entities.Lophoc;

public class LophocDAO {
	private Connection con;
	public LophocDAO() throws Exception {
		con=ConnectionFactory.getInstance().getConnection();
	}
	
	public boolean insert(Lophoc lh)throws Exception{
		String sql="insert into lophoc values(?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, lh.getMalop());
		stmt.setString(2, lh.getTenlop());
		return  stmt.executeUpdate()>0;
	}
	
	public ArrayList<Lophoc>getAll()throws Exception{
		String sql="select * from lophoc";
		ArrayList<Lophoc> ls=new ArrayList<>();
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Lophoc lh=new Lophoc(
					rs.getString("mslop"), 
					rs.getString("tenlop"));
			ls.add(lh);
		}
		return ls;
	}
}
