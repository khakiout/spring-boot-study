package hello.entity;

public enum TaskStatus {

	TODO("To Do"),
	WIP("WIP"),
	DONE("Done");
	
	private String name;
	
	private TaskStatus(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
