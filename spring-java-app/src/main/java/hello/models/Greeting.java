package hello.models;

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting)) return false;

        Greeting greeting = (Greeting) o;

        if (getId() != greeting.getId()) return false;
        return getContent().equals(greeting.getContent());

    }

}
