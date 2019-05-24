package library;

import java.util.ArrayList;
import java.util.Date;

public class Paper extends Publication {
    private ArrayList<Author> authors;
    private ArrayList<String> keyWords;

    public Paper(int id, String title, Editor editor, Date datePub) {
        super(id, title, editor, datePub);
        authors = new ArrayList<Author>();
        keyWords = new ArrayList<String>();
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

    public void addKeyWord(String keyWord) {
        keyWords.add(keyWord);
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Paper))
            return false;

        Paper other = (Paper) object;

        return this.getId() == other.getId() &&
               this.getTitle().equals(other.getTitle());
    }
}
