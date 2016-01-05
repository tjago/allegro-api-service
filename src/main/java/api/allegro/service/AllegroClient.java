package api.allegro.service;

import com.allegro.webapi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tjago on 2015-11-22.
 */
@Service
public class AllegroClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AllegroClient.class);
    protected static final int ROOT_CATEGORY_ID = 0;

    @Value("${allegro.api.key}")
    private String ALLEGRO_API_KEY;

    private final Converter converter;

    @Autowired
    public AllegroClient(Converter converter) {
        Assert.notNull(converter);
        this.converter = converter;
    }

    public List<AllegroItem> getAllegroItems(int categoryId, int itemsNumber) {

        log.info("calling Allegro Api service " + Constants.DO_GET_ITEMS_LIST_REQUEST_OPERATION);

        DoGetItemsListRequest request = buildRequestForDoGetItemsList(categoryId, itemsNumber);

        DoGetItemsListResponse response = (DoGetItemsListResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        Constants.ALLEGRO_SERVICE_URI,
                        request,
                        new SoapActionCallback(Constants.ALLEGRO_SERVICE_URI + "#" + Constants.DO_GET_ITEMS_LIST_REQUEST_OPERATION)
                );
        return converter.convertDoGetItemsListResponse(response);
    }


    public List<AllegroItem> getUniqueAllegroItems(int categoryId, int itemsNumber) {

        List<AllegroItem> itemList = getAllegroItems(categoryId, itemsNumber);

        return itemList.stream().distinct().collect(Collectors.toList());
    }

    /** Method grabs main categories
     * should be catched, because Allegro does not often change ID of main tree categories
     * @return
     */
    public List<AllegroCategory> getAllegroCategories() {

        log.info("calling Allegro Api service " + Constants.DO_GET_CATS_DATA_LIMIT_REQUEST_OPERATION);

        DoGetCatsDataLimitRequest request = new DoGetCatsDataLimitRequest();
        request.setCountryId(Constants.ALLEGRO_POLAND_COUNTRY_ID);
        request.setLocalVersion(Constants.ALLEGRO_LOCAL_VERSION);
        request.setWebapiKey( ALLEGRO_API_KEY );

        DoGetCatsDataLimitResponse response = (DoGetCatsDataLimitResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        Constants.ALLEGRO_SERVICE_URI,
                        request,
                        new SoapActionCallback(Constants.ALLEGRO_SERVICE_URI + "#" + Constants.DO_GET_CATS_DATA_LIMIT_REQUEST_OPERATION)
                );
        return converter.convertDoGetCatsDataLimitResponse(response);
    }

    public List<AllegroCategory> getRootAllegroCategories() {
        List<AllegroCategory> rootCategorieyList = new ArrayList<>();

        for (AllegroCategory category : getAllegroCategories()) {
            if (category.getParent() == ROOT_CATEGORY_ID) {
                rootCategorieyList.add( category );
            }
        }
        return rootCategorieyList;
    }

        private DoGetItemsListRequest buildRequestForDoGetItemsList(int categoryId, int itemsNumber) {

        if (ALLEGRO_API_KEY == null || ALLEGRO_API_KEY.length() == 0) {
            log.error("API key not existing!");
            throw new RuntimeException("no api key!");
        }

        ArrayOfString arrayofCategory = new ArrayOfString();
        arrayofCategory.getItem().add( String.valueOf(categoryId) );

        FilterOptionsType filterOptionsType = new FilterOptionsType();
        filterOptionsType.setFilterId("category");
        filterOptionsType.setFilterValueId( arrayofCategory );

        ArrayOfFilteroptionstype arrayOfFilteroptionstype = new ArrayOfFilteroptionstype();
        arrayOfFilteroptionstype.getItem().add(filterOptionsType);

        DoGetItemsListRequest request = new DoGetItemsListRequest();
        request.setCountryId( Constants.ALLEGRO_POLAND_COUNTRY_ID );
        request.setWebapiKey( ALLEGRO_API_KEY );
        request.setResultSize( itemsNumber );
        request.setResultScope(Constants.NIE_ZWRACAJ_STRUKTURY_Z_FILTRAMI );
        request.setFilterOptions( arrayOfFilteroptionstype );
        return request;
    }

}
