package session03.ex01;

public class Driver {

	public static void main(String[] args) {
		Employee e=new Employee(10001, "Thân Thị Đẹt", 10000d);
		//e--->(generate) json document???
		String json=new JsonGenerate(e).gen();
	}

}
