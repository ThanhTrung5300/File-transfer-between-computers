package session01.ex01.normal;

public class ExcecuteIt {
	public static void main(String[] args) {
		TaskA ta=new TaskA("Collect Data", 1000);
		TaskB tb=new TaskB("Process data", 1200);
		
		ta.doA();
		tb.doB();
		
		System.out.println(Thread.currentThread());
	}
}
