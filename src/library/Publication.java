package library;

import java.util.Date;

public abstract class Publication {
    private int id;
    private String title;
    private Editor editor;
    private Date datePub;

    protected Publication(int id, String title, Editor editor, Date datePub) {
        setId(id);
        setTitle(title);
        setEditor(editor);
        setDatePub(datePub);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Date getDatePub() {
        return datePub;
    }

    public void setDatePub(Date datePub) {
        this.datePub = datePub;
    }
}
