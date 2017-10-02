package session01.ex01.normal;

public class TaskA {
	private String taskName;
	private int count;
	
	public TaskA(String taskName, int count) {
		this.taskName = taskName;
		this.count = count;
	}


	public void doA() {
		for (int i = 0; i < count; i++) {
			System.out.println(taskName +"#"+i);
		}
	}
}
