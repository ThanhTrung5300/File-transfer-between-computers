package session01.ex01.thread;
//bước 1: Tạo các lớp tác vụ threo nguyên tắc
//là implements từ Runnable interface
public class TaskA implements Runnable{
	private String taskName;
	private int count;
	
	public TaskA(String taskName, int count) {
		this.taskName = taskName;
		this.count = count;
	}


	private void doA() {
		for (int i = 0; i < count; i++) {
			System.out.println(taskName +"#"+i);
		}
	}


	@Override
	public void run() {
		doA();
	}
	
}
