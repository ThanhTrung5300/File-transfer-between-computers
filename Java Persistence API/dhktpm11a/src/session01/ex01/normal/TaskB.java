package session01.ex01.normal;

public class TaskB {
		private String taskName;
		private int count;
		
		
		public TaskB(String taskName, int count) {
			this.taskName = taskName;
			this.count = count;
		}


		public void doB() {
			for (int i = 0; i < count; i++) {
				System.out.println(taskName +"#"+i);
			}
		}

}
