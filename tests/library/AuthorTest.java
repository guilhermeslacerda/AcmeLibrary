package library;

import library.Author;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthorTest {
    private Author me, you;

    @Before
    public void setUp() {
        me = new Author(1, "Guilherme", "Lacerda");
    }

    @Test
    public void getId() {
        assertEquals(1, me.getId());
    }

    @Test
    public void getName() {
        assertEquals("Guilherme", me.getName());
    }

    @Test
    public void getLastName() {
        assertEquals("Lacerda", me.getLastName());
    }

    @Test
    public void testToString() {
        assertEquals("Lacerda, Guilherme", me.toString());
    }

    @Test
    public void testMeIsMe() {
        assertTrue(me.equals(me));
    }

    @Test
    public void testMeIsNotTheSame() {
        you = new Author(2, "Fabio", "Petrillo");
        assertFalse(me.equals(you));
        assertFalse(me.equals(new Object()));

        you = new Author(1, "Fabio", "Petrillo");
        assertFalse(me.equals(you));

        you = new Author(1, "Guilherme", "Petrillo");
        assertFalse(me.equals(you));
    }
}
