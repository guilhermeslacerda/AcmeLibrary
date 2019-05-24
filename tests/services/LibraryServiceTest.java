package services;

import library.exceptions.InvalidAuthorException;
import library.exceptions.InvalidEditorException;
import library.exceptions.InvalidPublicationException;
import library.*;
import repository.InMemoryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

public class LibraryServiceTest {
    private LibraryService ls;
    private Author me, you;
    private Editor editor;
    private Magazine mag;
    private final String TITLE = "Agile Magazine";
    private final String TITLE_PAPER = "Refactoring and Software Visualization";
    private Date datePub;
    private Paper paper;

    @Before
    public void init() {
        ls = LibraryService.getInstance();
        ls.defineRepository(new InMemoryRepository());
    }

    @Test
    public void addAuthor() {
        createAuthors();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addAuthor(me);
        assertEquals(1, ls.getRepository().sizeAgents());
    }

    @Test
    public void addTwoAuthors() {
        createAuthors();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addAuthor(me);
        ls.addAuthor(you);
        assertEquals(2, ls.getRepository().sizeAgents());
    }

    @Test
    public void addEditor() {
        createEditor();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addEditor(editor);
        assertEquals(1, ls.getRepository().sizeAgents());
    }

    @Test
    public void findOneAuthor() {
        createAuthors();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addAuthor(me);
        ls.addAuthor(you);
        assertEquals(2, ls.getRepository().sizeAgents());
        try {
            Author someOne = ls.findAuthor(1);
            assertTrue(someOne.equals(me));
        } catch (InvalidAuthorException e) {
            assertEquals("Author not found", e.getMessage());
        }
    }

    @Test
    public void testForAuthorNotFound() {
        createAuthors();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addAuthor(me);
        ls.addAuthor(you);
        assertEquals(2, ls.getRepository().sizeAgents());
        try {
            Author someOne = ls.findAuthor(3);
            //fail();
        } catch (InvalidAuthorException e) {
            assertEquals("Author not found", e.getMessage());
        }
    }

    @Test
    public void findOneEditor() {
        createEditor();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addEditor(editor);
        assertEquals(1, ls.getRepository().sizeAgents());
        try {
            Editor someOne = ls.findEditor(1);
            assertTrue(someOne.equals(editor));
        } catch (InvalidEditorException e) {
            assertEquals("Editor not found", e.getMessage());
        }
    }

    @Test
    public void testForEditorNotFound() {
        createEditor();
        assertEquals(0, ls.getRepository().sizeAgents());
        ls.addEditor(editor);
        assertEquals(1, ls.getRepository().sizeAgents());
        try {
            Editor someOne = ls.findEditor(2);
            assertTrue(someOne.equals(editor));
            fail();
        } catch (InvalidEditorException e) {
            assertEquals("Editor not found", e.getMessage());
        }
    }

    @Test
    public void addPaperMagazine() {
        createMagazine();
        assertNotNull(mag);
        createPapers();
        assertEquals(0, ls.getRepository().sizePublications());
        ls.addPublication(paper);
        assertEquals(1, ls.getRepository().sizePublications());
    }

    @Test
    public void findOnePublication() {
        createMagazine();
        assertNotNull(mag);
        createPapers();
        assertEquals(0, ls.getRepository().sizePublications());
        ls.addPublication(paper);
        assertEquals(1, ls.getRepository().sizePublications());

        try {
            Publication somePub = ls.findPublication(1);
            if (somePub instanceof Magazine) {
                Magazine otherMag = (Magazine) somePub;
                assertTrue(somePub.equals(mag));
            }
        } catch (InvalidPublicationException e) {
            assertEquals("Publication not found", e.getMessage());
        }
    }

    @Test
    public void findOnePublicationWhichNotExist() {
        createMagazine();
        assertNotNull(mag);
        createPapers();
        assertEquals(0, ls.getRepository().sizePublications());
        ls.addPublication(paper);
        assertEquals(1, ls.getRepository().sizePublications());

        try {
            Publication somePub = ls.findPublication(2);
            if (somePub instanceof Magazine) {
                Magazine otherMag = (Magazine) somePub;
                assertTrue(somePub.equals(mag));
            }
        } catch (InvalidPublicationException e) {
            assertEquals("Publication not found", e.getMessage());
        }
    }

    @Test
    public void removeOnePublication() {
        createMagazine();
        assertNotNull(mag);
        createPapers();
        assertEquals(0, ls.getRepository().sizePublications());
        ls.addPublication(paper);
        assertEquals(1, ls.getRepository().sizePublications());

        try {
            assertTrue(ls.removePublication(1));
            assertEquals(0, ls.getRepository().sizePublications());
        } catch (InvalidPublicationException e) {
            assertEquals("Publication not found", e.getMessage());
        }
    }

    @Test
    public void removeOnePublicationWhichNotExist() {
        createMagazine();
        assertNotNull(mag);
        createPapers();
        assertEquals(0, ls.getRepository().sizePublications());
        ls.addPublication(paper);
        assertEquals(1, ls.getRepository().sizePublications());

        try {
            assertTrue(ls.removePublication(2));
            fail();
        } catch (InvalidPublicationException e) {
            assertEquals("Publication not found", e.getMessage());
        }
    }

    private void createMagazine() {
        datePub = new Date();
        createEditor();
        mag = new Magazine(1, TITLE, editor, datePub);
    }

    private void createPapers() {
        createAuthors();
        paper = new Paper(1, TITLE_PAPER, editor, datePub);
        paper.addAuthor(me);
        paper.addAuthor(you);
        paper.addKeyWord("refactoring");
   }

    private void createAuthors() {
        me = new Author(1, "Guilherme", "Lacerda");
        you = new Author(2, "Fabio", "Petrillo");
    }

    private void createEditor() {
        editor = new Editor(1, "Marcelo Pimenta");
    }
}