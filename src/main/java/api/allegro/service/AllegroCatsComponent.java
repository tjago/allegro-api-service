package api.allegro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created by tjago on 2015-11-26.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AllegroCatsComponent {

    @Autowired
    AllegroClient allegroClient;

    private Random random = new Random();
    private List<AllegroCategory> catsList;


    public List<AllegroCategory> getCats() {
        return catsList;
    }

    public void setCatsList(List<AllegroCategory> catsList) {
        this.catsList = catsList;
    }

    public Long getRandomCatId() {

        int index = random.nextInt(catsList.size());
        return catsList.get( index ).getId();
    }
}
