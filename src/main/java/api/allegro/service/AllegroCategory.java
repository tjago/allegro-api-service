package api.allegro.service;

/**
 * Created by tjago on 2015-11-26.
 */
public class AllegroCategory {
    private int id;
    private int parent;
    private String name;

    public AllegroCategory(int id, int parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
