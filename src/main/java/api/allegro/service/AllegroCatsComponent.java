package api.allegro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(AllegroCatsComponent.class);

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

    public int getRandomCatId() {

        int index = random.nextInt(catsList.size());

        log.info("Chosen category : id={} name={}", catsList.get( index ).getId(), catsList.get( index ).getName() );

        return catsList.get( index ).getId();
    }
}
