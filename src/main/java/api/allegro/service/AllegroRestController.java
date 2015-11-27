package api.allegro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllegroRestController {

    @Autowired
    private AllegroClient allegroClient;

    @Autowired
    private AllegroCatsComponent catsComponent;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "<h2>Allegro api service</h2>";
    }

    @RequestMapping("/allegro/offers")
    public List<AllegroItem> allegroOffers() {
        return allegroClient.getUniqueAllegroItems(catsComponent.getRandomCatId(), Constants.ITEMS_FETCHED_AT_ONCE);
    }

    @RequestMapping("/allegro/preferredoffers")
    public List<AllegroItem> allegroOffersPreffered() {
        return allegroClient.getAllegroItems(catsComponent.getRandomCatId(), Constants.ITEMS_FETCHED_AT_ONCE); //TODO implement preferred Offers functionality
    }
}