package api.allegro.service;

/**
 * Created by tjago on 2015-11-22.
 */
public class Constants {

    //program params
    protected static final int ITEMS_FETCHED_AT_ONCE = 20; //TODO extract to options

    //hardcoded cats for test class
    public static final int CATEGORY_KSIAZKI_I_KOMIKSY_ID = 7;
    public static final int CATEGORY_KONSOLEI_AUTOMATY_ID = 122_233;


    public static final String ALLEGRO_SERVICE_URI = "https://webapi.allegro.pl/service.php";
    public static final String ALLEGRO_ITEM_URI_WITHOUT_ID = "http://allegro.pl/show_item.php?item=";

    //WSDL operations
    protected static final String DO_GET_ITEMS_LIST_REQUEST_OPERATION = "DoGetItemsListRequest";
    protected static final String DO_GET_CATS_DATA_LIMIT_REQUEST_OPERATION = "DoGetCatsDataLimitRequest";

    //WSDL keys
    public static final int ALLEGRO_POLAND_COUNTRY_ID = 1;
    public static final Long ALLEGRO_LOCAL_VERSION = 16_551_276L;
    protected static final int NIE_ZWRACAJ_STRUKTURY_Z_FILTRAMI = 1;
}
