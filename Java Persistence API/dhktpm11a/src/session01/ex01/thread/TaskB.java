package session01.ex01.thread;

public class TaskB implements Runnable{
		private String taskName;
		private int count;
		
		
		public TaskB(String taskName, int count) {
			this.taskName = taskName;
			this.count = count;
		}


		private void doB() {
			for (int i = 0; i < count; i++) {
				System.out.println(taskName +"#"+i);
			}
		}


		@Override
		public void run() {
			doB();
		}

}
