package library;

import library.Author;
import library.Editor;
import library.Magazine;
import library.Paper;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MagazineTest {
    private Magazine mag;
    private Editor editor;
    private Date datePub;
    private Paper paper, otherPaper;
    private final String EDITOR = "Marcelo Pimenta";
    private final String TITLE = "Agile Magazine";
    private final String TITLE_PAPER = "Refactoring and Software Visualization";
    private final String OTHER_TITLE_PAPER = "TDD and Clean Code";
    private Author me, you;

    @Before
    public void setUp() {
        editor = new Editor(1, EDITOR);
        datePub = new Date();
    }

    @Test
    public void createMagazine() {
        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertEquals(EDITOR, mag.getEditor().getName());
    }

    @Test
    public void addPaperMagazine() {
        preparePaper();
        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertNotNull(me);
        assertNotNull(you);
        assertNotNull(paper);
        assertTrue(mag.getPapers().isEmpty());
        mag.addPaperIn(paper);
        assertEquals(1, mag.getPapers().size());
    }

    @Test
    public void removePaperMagazine() {
        preparePaper();
        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertNotNull(paper);
        assertTrue(mag.getPapers().isEmpty());
        mag.addPaperIn(paper);
        assertEquals(1, mag.getPapers().size());
        assertTrue(mag.removePaper(paper));
        assertTrue(mag.getPapers().isEmpty());
    }

    @Test
    public void removePaperMagazineWhenIsEmpty() {
        preparePaper();
        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertNotNull(paper);
        assertTrue(mag.getPapers().isEmpty());
        mag.addPaperIn(paper);
        assertEquals(1, mag.getPapers().size());
        assertTrue(mag.removePaper(paper));
        assertTrue(mag.getPapers().isEmpty());
        assertFalse(mag.removePaper(paper));
        assertTrue(mag.getPapers().isEmpty());
    }

    @Test
    public void verifyDatePublication() {
        Calendar c = Calendar.getInstance();
        c.setTime(datePub);

        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertEquals(c.getTime(), mag.getDatePub());
    }

    @Test
    public void tryRemoveOtherPaperMagazine() {
        preparePaper();
        mag = new Magazine(1, TITLE, editor, datePub);
        assertNotNull(mag);
        assertNotNull(paper);
        assertTrue(mag.getPapers().isEmpty());
        mag.addPaperIn(paper);
        assertEquals(1, mag.getPapers().size());
        prepareAnotherPaper();
        assertFalse(mag.removePaper(otherPaper));
        assertEquals(1, mag.getPapers().size());
    }

    private void prepareAnotherPaper() {
        me = new Author(3, "Kent", "Beck");
        you = new Author(4, "Robert", "Martin");
        otherPaper = new Paper(2, OTHER_TITLE_PAPER, editor, datePub);
        otherPaper.addAuthor(me);
        otherPaper.addAuthor(you);
        otherPaper.addKeyWord("clean code");
    }

    private void preparePaper() {
        me = new Author(1, "Guilherme", "Lacerda");
        you = new Author(2, "Fabio", "Petrillo");
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        paper.addAuthor(me);
        paper.addAuthor(you);
        paper.addKeyWord("refactoring");
    }
}