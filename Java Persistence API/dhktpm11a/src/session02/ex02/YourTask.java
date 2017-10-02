package session02.ex02;

public class YourTask implements Runnable {

	private String taskName;
	private int times;


	public YourTask(String taskName, int times) {
		this.taskName = taskName;
		this.times = times;
	}


	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.println(taskName +"#"+i);
		}
	}
}
