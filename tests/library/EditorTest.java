package library;

import library.Editor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditorTest {
    private Editor someOne;

    @Before
    public void setUp() {
        someOne = new Editor(1, "John");
    }

    @Test
    public void getId() {
        assertEquals(1, someOne.getId());
    }

    @Test
    public void getName() {
        assertEquals("John", someOne.getName());
    }

    @Test
    public void testToString() {
        assertEquals("John [1]", someOne.toString());
    }
}
