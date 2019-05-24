package library;

public class Author extends Agent {
    private String name;
    private String lastName;

    public Author(int id, String name, String lastName) {
        super(id);
        setName(name);
        setLastName(lastName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getName();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Author))
            return false;

        Author other = (Author) object;

        return this.getId() == other.getId() &&
                this.getLastName().equals(other.getLastName()) &&
                this.getName().equals(other.getName());
    }
}
