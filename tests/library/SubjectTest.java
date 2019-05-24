package library;

import library.Subject;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SubjectTest {
    private Subject subject;

    @Before
    public void setUp() {
        subject = new Subject(1, "Information Technology");
    }

    @Test
    public void getId() {
        assertEquals(1, subject.getId());
    }

    @Test
    public void getDescription() {
        assertEquals("Information Technology", subject.getDescription());
    }
}
