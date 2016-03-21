package api.allegro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllegroRestController {

    private AllegroClient allegroClient;
    private AllegroCatsComponent catsComponent;

    @Autowired
    public AllegroRestController(AllegroClient allegroClient, AllegroCatsComponent allegroCatsComponent) {
        Assert.notNull(allegroCatsComponent);
        Assert.notNull(allegroClient);
        this.allegroClient = allegroClient;
        this.catsComponent = allegroCatsComponent;
    }

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "<h2>Allegro api service</h2>";
    }

    @CrossOrigin
    @RequestMapping("/allegro/offers")
    public List<AllegroItem> allegroOffers() {
        return allegroClient.getUniqueAllegroItems(catsComponent.getRandomCatId(), Constants.ITEMS_FETCHED_AT_ONCE);
    }

    @RequestMapping("/allegro/preferredoffers")
    public List<AllegroItem> allegroOffersPreffered() {
        return allegroClient.getAllegroItems(catsComponent.getRandomCatId(), Constants.ITEMS_FETCHED_AT_ONCE); //TODO implement preferred Offers functionality
    }
}