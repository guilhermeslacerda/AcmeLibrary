package library;

public class Editor extends Agent {
    private String name;

    public Editor(int id, String name) {
        super(id);
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() + " [" + getId() + "]";
    }
}
