package api.allegro.service;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by tjago on 2015-11-22.
 */
public class Constants {

    public static final String CATEGORY_KSIAZKI_I_KOMIKSY_ID = "7";
    public static final String CATEGORY_KONSOLEI_AUTOMATY_ID = "122233";
    public static final String ALLEGRO_SERVICE_URI = "https://webapi.allegro.pl/service.php";
    public static final String ALLEGRO_ITEM_URI_WITHOUT_ID = "http://allegro.pl/show_item.php?item=";

    protected static final String DO_GET_ITEMS_LIST_REQUEST_OPERATION = "#DoGetItemsListRequest";
    protected static final int ITEMS_FETCHED_AT_ONCE = 50;


}
