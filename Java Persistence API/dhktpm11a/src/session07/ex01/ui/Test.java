package session07.ex01.ui;

import java.util.ArrayList;

import session07.ex01.controls.ConnectionFactory;
import session07.ex01.dao.LophocDAO;
import session07.ex01.entities.Lophoc;

public class Test {
	public static void main(String[] args) throws Exception {
		LophocDAO dao=new LophocDAO();
		dao.insert(new Lophoc("XYZ","Lớp gì đó"));
		
		ArrayList<Lophoc> ls = dao.getAll();
		for(Lophoc l:ls)
			System.out.println(l);
	
	ConnectionFactory.getInstance().close();
	
	}
}
