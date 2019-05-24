package library;

import library.Author;
import library.Editor;
import library.Paper;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaperTest {
    private Editor editor;
    private Date datePub;
    private Paper paper, otherPaper;
    private final String EDITOR = "Marcelo Pimenta";
    private final String TITLE_PAPER = "Refactoring and Software Visualization";
    private final String OTHER_TITLE_PAPER = "TDD and Clean Code";
    private Author me, you;

    @Before
    public void setUp() {
        editor = new Editor(1, EDITOR);
        datePub = new Date();
        me = new Author(1, "Guilherme", "Lacerda");
        you = new Author(2, "Fabio", "Petrillo");
    }

    @Test
    public void createPaper() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertNotNull(paper);
        assertEquals(EDITOR, paper.getEditor().getName());
    }

    @Test
    public void addAuthors() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertNotNull(paper);
        assertTrue(paper.getAuthors().isEmpty());
        addingAuthorsAndKeyWords();
        assertNotNull(me);
        assertNotNull(you);
        assertEquals(2, paper.getAuthors().size());
    }

    @Test
    public void removeOneAuthor() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertNotNull(paper);
        assertTrue(paper.getAuthors().isEmpty());
        addingAuthorsAndKeyWords();
        assertNotNull(me);
        assertNotNull(you);
        assertEquals(2, paper.getAuthors().size());
        assertTrue(paper.removeAuthor(you));
        assertEquals(1, paper.getAuthors().size());
    }

    @Test
    public void tryRemoveAuthorWhenListIsEmpty() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertNotNull(paper);
        addingAuthorsAndKeyWords();
        assertNotNull(me);
        assertNotNull(you);
        assertEquals(2, paper.getAuthors().size());
        assertTrue(paper.removeAuthor(me));
        assertTrue(paper.removeAuthor(you));
        assertTrue(paper.getAuthors().isEmpty());
        assertFalse(paper.removeAuthor(me));
    }

    @Test
    public void testKeyWords() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertNotNull(paper);
        addingAuthorsAndKeyWords();
        assertEquals(1, paper.getKeyWords().size());
    }

    @Test
    public void testPaperIsTheSame() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        assertTrue(paper.equals(paper));
    }

    @Test
    public void testPaperIsNotTheSame() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        otherPaper = new Paper(2, OTHER_TITLE_PAPER, editor, datePub);
        assertFalse(paper.equals(otherPaper));
        assertFalse(paper.equals(new Object()));

        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        otherPaper = new Paper(1, OTHER_TITLE_PAPER, editor, datePub);
        assertFalse(paper.equals(otherPaper));
    }

    private void addingAuthorsAndKeyWords() {
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        paper.addAuthor(me);
        paper.addAuthor(you);
        paper.addKeyWord("refactoring");
    }
}