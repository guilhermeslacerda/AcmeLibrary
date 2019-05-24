package services;

import library.Author;
import library.Editor;
import library.Publication;
import library.exceptions.InvalidAuthorException;
import library.exceptions.InvalidEditorException;
import library.exceptions.InvalidPublicationException;
import repository.DataRepository;

public class LibraryService {
    private DataRepository repository;
    private static LibraryService singleton = new LibraryService();

    public static LibraryService getInstance() {
        return singleton;
    }

    public void defineRepository(DataRepository repository) {
        this.repository = repository;
    }

    public void addAuthor(Author author) {
        repository.addAuthor(author);
    }

    public void addEditor(Editor editor) {
        repository.addEditor(editor);
    }

    public Author findAuthor(int id) throws InvalidAuthorException {
        return repository.findAuthor(id);
    }

    public Editor findEditor(int id) throws InvalidEditorException {
        return repository.findEditor(id);
    }

    public DataRepository getRepository() {
        return repository;
    }

    public void addPublication(Publication pub) {
        repository.addPublication(pub);
    }

    public Publication findPublication(int id) throws InvalidPublicationException {
        return repository.findPublication(id);
    }

    public boolean removePublication(int id) throws InvalidPublicationException {
        return repository.removePublication(id);
    }
}
