package hello.models;

import java.util.List;
import java.util.ArrayList;

public class Persoana {
    private String name;
	private int id;

    public Persoana() {}

    public Persoana(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
	
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persoana)) return false;

        Persoana persoana = (Persoana) o;

        if (getId() != persoana.getId()) return false;
        return getName().equals(persoana.getName());

    }

}
