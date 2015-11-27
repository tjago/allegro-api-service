package api.allegro.service;

import com.allegro.webapi.*;
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
    protected static final String SMALL_PHOTO = "small";
    protected static final String MEDIUM_PHOTO = "medium";
    protected static final String LARGE_PHOTO = "large";

    public List<AllegroItem> convertDoGetItemsListResponse(DoGetItemsListResponse response) {

        log.info("Converting " + response.getClass().getSimpleName() + " to " + AllegroItem.class.getSimpleName());

        if (
                response != null &&
                response.getItemsList() != null &&
                response.getItemsList().getItem() != null &&
                response.getItemsList().getItem().size() > 0
                ) {

            List<AllegroItem> allegroItemList = new ArrayList<>();

            for ( ItemsListType item : response.getItemsList().getItem()) {
                String largePhotoUrl = pickLargePhoto( item.getPhotosInfo().getItem() );
                if (largePhotoUrl == null || item.getSellerInfo() == null) {
                    continue; //ignore items without large photos
                }

                AllegroItem allegroItem = new AllegroItem(
                        item.getItemId(),
                        largePhotoUrl,
                        Constants.ALLEGRO_ITEM_URI_WITHOUT_ID + item.getItemId(),
                        item.getItemTitle(),
                        item.getCategoryId(),
                        item.getSellerInfo().getUserId()
                );
                allegroItemList.add( allegroItem );
                log.debug("Dodano: " + allegroItem.toString());
            }

            return allegroItemList;
        }
        return null;
    }

    private String pickLargePhoto(List<PhotoInfoType> photoList) {

        for ( PhotoInfoType photo : photoList) {
            if ( photo.getPhotoSize().equals(LARGE_PHOTO)) {
                return photo.getPhotoUrl();
            }
        }
        return null;
    }



    public List<AllegroCategory> convertDoGetCatsDataLimitResponse(DoGetCatsDataLimitResponse response) {

        log.info("Converting " + response.getClass().getSimpleName() + " to " + AllegroCategory.class.getSimpleName());

        if (response != null && response.getCatsList().getItem().size() > 0 ) {
            List<AllegroCategory> allegroCategoryList = new ArrayList<>();

            for ( CatInfoType cat : response.getCatsList().getItem()) {
                AllegroCategory allegorCategory = new AllegroCategory(Long.parseLong(String.valueOf(cat.getCatId())), cat.getCatName());
                allegroCategoryList.add(allegorCategory);
            }
            return allegroCategoryList;
        }
        return null;
    }
}
