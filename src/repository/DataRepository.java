package repository;

import library.exceptions.InvalidAuthorException;
import library.exceptions.InvalidEditorException;
import library.exceptions.InvalidPublicationException;
import library.Author;
import library.Editor;
import library.Publication;

public interface DataRepository {
    void addAuthor(Author author);
    void addEditor(Editor editor);
    Author findAuthor(int id) throws InvalidAuthorException;
    Editor findEditor(int id) throws InvalidEditorException;
    void addPublication(Publication pub);
    boolean removePublication(int id) throws InvalidPublicationException;
    Publication findPublication(int id) throws InvalidPublicationException;
    int sizeAgents();
    int sizePublications();
}
