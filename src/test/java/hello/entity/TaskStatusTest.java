package hello.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskStatusTest {

	@Test
	public void testToString() {
		assertEquals("To Do", TaskStatus.TODO.toString());
		assertEquals("WIP", TaskStatus.WIP.toString());
		assertEquals("Done", TaskStatus.DONE.toString());
	}
	
}
