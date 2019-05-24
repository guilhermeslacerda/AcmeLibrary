package library;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication {
    private Subject subject;
    private ArrayList<Author> authors;

    public Book(int id, String title, Editor editor, Date datePub, Subject subject) {
        super(id, title, editor, datePub);
        setSubject(subject);
        authors = new ArrayList<Author>();
    }

    private void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public boolean removeAuthor(Author author) {
        for (int x = 0; x < authors.size(); x++) {
            Author other = authors.get(x);
            if (other.equals(author)) {
                authors.remove(x);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
}
