package api.allegro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GeneralController {

    @Autowired
    private AllegroClient allegroClient;

    @Autowired
    private MockingService mockingService;

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "<h2>snapbuyer Service App</h2>";
    }

    @RequestMapping("/allegro/offers")
    public List<AllegroItem> allegroOffers() {
        return allegroClient.getAllegroItems(Constants.CATEGORY_KSIAZKI_I_KOMIKSY_ID, Constants.ITEMS_FETCHED_AT_ONCE);
    }

    @RequestMapping("/allegro/preferredoffers")
    public List<AllegroItem> allegroOffersPreffered() {
        return allegroOffers(); //TODO implement preferred Offers functionality
    }
}