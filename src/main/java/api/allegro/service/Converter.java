package api.allegro.service;

import com.allegro.webapi.DoGetItemsListResponse;
import com.allegro.webapi.ItemsListType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tjago on 2015-11-22.
 */
@Service
public class Converter {

    private static final Logger log = LoggerFactory.getLogger(Converter.class);

    public List<AllegroItem> convertDoGetItemsListResponse(DoGetItemsListResponse response) {

        if (response != null && response.getItemsList().getItem().size() > 0) {
            List<AllegroItem> allegroItemList = new ArrayList<>();

            for ( ItemsListType item : response.getItemsList().getItem()) {
                AllegroItem allegroItem = new AllegroItem(
                        item.getItemId(),
                        item.getPhotosInfo().getItem().get(2).getPhotoUrl(), //largePhoto 300x400
                        Constants.ALLEGRO_ITEM_URI_WITHOUT_ID + item.getItemId(),
                        item.getItemTitle(),
                        item.getCategoryId()
                );
                allegroItemList.add( allegroItem );
                log.info("Dodano: " + allegroItem.toString());
            }

            return allegroItemList;
        }
        return null;
    }
}
