package library;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
    private ArrayList<Paper> papers;

    public Magazine(int id, String title, Editor editor, Date datePub) {
        super(id, title, editor, datePub);
        papers = new ArrayList<Paper>();
    }

    public void addPaperIn(Paper paper) {
        papers.add(paper);
    }

    public boolean removePaper(Paper paper) {
        for (int x = 0; x < papers.size(); x++) {
            Paper other = papers.get(x);
            if (other.equals(paper)) {
                papers.remove(x);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Paper> getPapers() {
        return papers;
    }
}
