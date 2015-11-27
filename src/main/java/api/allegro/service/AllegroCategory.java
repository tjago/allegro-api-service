package api.allegro.service;

/**
 * Created by tjago on 2015-11-26.
 */
public class AllegroCategory {
    private Long id;
    private String name;

    public AllegroCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
