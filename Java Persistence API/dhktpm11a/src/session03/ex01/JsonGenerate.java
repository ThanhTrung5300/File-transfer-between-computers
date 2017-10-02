package session03.ex01;

import java.lang.reflect.Field;

public class JsonGenerate {

	private Employee e;

	public JsonGenerate(Employee e) {
		this.e=e;
	}

	public String gen() {
		return null;
	}
	
	String a() throws Exception {
		String json="{";
		Class<?>cls=Class.forName(e.getClass().getName());
		Field[] fields = cls.getDeclaredFields();
		for(Field f:fields) {
			String name=f.getName();
			json+="\""+name+"\":";
			String value="";
			json+="\""+value+"\",";
		}
		json=json.substring(0, json.length()-1);
		json+="}";
		return json;
	}
	public static void main(String[] args) throws Exception {
		Employee emp=new Employee(1001, "Thân thị đẹt", 1000d);
		JsonGenerate j=new JsonGenerate(emp);
		System.out.println(j.a());
	}
	
}

///reflection