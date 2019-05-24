package repository;

import library.exceptions.InvalidAuthorException;
import library.exceptions.InvalidEditorException;
import library.exceptions.InvalidPublicationException;
import library.Agent;
import library.Author;
import library.Editor;
import library.Publication;

import java.util.HashMap;

public class InMemoryRepository implements DataRepository {
    private HashMap<Integer, Agent> agents = new HashMap<Integer, Agent>();
    private HashMap<Integer, Publication> pubs = new HashMap<Integer, Publication>();

    @Override
    public void addAuthor(Author author) {
        agents.put(author.getId(), author);
    }

    @Override
    public void addEditor(Editor editor) {
        agents.put(editor.getId(), editor);
    }

    @Override
    public Author findAuthor(int id) throws InvalidAuthorException {
        if (!agents.containsKey(id))
            throw new InvalidAuthorException("Author not found");
        Author author = (Author) agents.get(id);

        return author;
    }

    @Override
    public Editor findEditor(int id) throws InvalidEditorException {
        if (!agents.containsKey(id))
            throw new InvalidEditorException("Editor not found");
        Editor editor = (Editor) agents.get(id);

        return editor;
    }

    @Override
    public void addPublication(Publication pub) {
        pubs.put(pub.getId(), pub);
    }

    @Override
    public boolean removePublication(int id) throws InvalidPublicationException {
        if (!pubs.containsKey(id))
            throw new InvalidPublicationException("Publication not found");
        pubs.remove(id);
        return true;
    }

    @Override
    public Publication findPublication(int id) throws InvalidPublicationException {
        if (!pubs.containsKey(id))
            throw new InvalidPublicationException("Publication not found");
        Publication pub = (Publication) pubs.get(id);

        return pub;
    }

    @Override
    public int sizeAgents() {
        return agents.size();
    }

    @Override
    public int sizePublications() {
        return pubs.size();
    }
}