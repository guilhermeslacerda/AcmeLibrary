package library;

public abstract class Agent {
    private int id;

    public Agent(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
