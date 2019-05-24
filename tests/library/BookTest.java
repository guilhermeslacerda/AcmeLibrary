package library;

import library.Author;
import library.Book;
import library.Editor;
import library.Subject;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BookTest {
    private Book book;
    private Editor editor;
    private Date datePub;
    private Subject subject;
    private final String EDITOR = "Marcelo Pimenta";
    private final String TITLE = "Coding By Example";
    private Author me, you;

    @Before
    public void setUp() {
        editor = new Editor(1, EDITOR);
        datePub = new Date();
        subject = new Subject(1, "agile methods");
    }

    @Test
    public void createBook() {
        book = new Book(1, TITLE, editor, datePub, subject);
        assertNotNull(book);
        assertEquals(EDITOR, book.getEditor().getName());
        assertEquals(subject.getDescription(), book.getSubject().getDescription());
    }

    @Test
    public void addAuthorToBook() {
        prepareAuthor();
        book = new Book(1, TITLE, editor, datePub, subject);
        assertNotNull(book);

        assertNotNull(me);
        assertNotNull(you);

        assertTrue(book.getAuthors().isEmpty());
        book.addAuthor(me);
        book.addAuthor(you);
        assertEquals(2, book.getAuthors().size());
    }

    @Test
    public void removeAuthorFromBook() {
        prepareAuthor();
        book = new Book(1, TITLE, editor, datePub, subject);
        assertNotNull(book);

        assertNotNull(me);
        assertNotNull(you);

        assertTrue(book.getAuthors().isEmpty());
        book.addAuthor(me);
        book.addAuthor(you);
        assertEquals(2, book.getAuthors().size());
        assertTrue(book.removeAuthor(you));
        assertEquals(1, book.getAuthors().size());
    }

    @Test
    public void removeAuthorFromBookWhenListIsEmpty() {
        prepareAuthor();
        book = new Book(1, TITLE, editor, datePub, subject);
        assertNotNull(book);

        assertNotNull(me);
        assertNotNull(you);

        assertTrue(book.getAuthors().isEmpty());
        book.addAuthor(me);
        assertEquals(1, book.getAuthors().size());
        assertTrue(book.removeAuthor(me));
        assertEquals(0, book.getAuthors().size());
        assertFalse(book.removeAuthor(me));
    }

    private void prepareAuthor() {
        me = new Author(1, "Guilherme", "Lacerda");
        you = new Author(2, "Fabio", "Petrillo");
    }
}