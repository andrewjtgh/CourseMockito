package course;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {
	private INameList mockedList;
	private Course course;

	@BeforeEach
	public void setUp() {
		mockedList = mock(INameList.class);
		course = new Course(mockedList);
	}

	@Test
	public void testGetAttendee() {
		when(mockedList.getName(0)).thenReturn("Alice");
		when(mockedList.getName(1)).thenReturn("Bob");
		when(mockedList.getName(-1)).thenThrow(new RuntimeException());
		assertEquals("Bob", course.getAttendee(1));
		try {
			course.getAttendee(-1);
			fail();
		} catch (RuntimeException e) {}
	}

	@Test
	public void testAddAttendee() {
		course.addAttendee("Jennifer");
		verify(mockedList).addName("Jennifer");
	}

	@Test
	public void testClearAttendee() {
		course.clearAttendeesList();
		verify(mockedList).clear();
	}
}