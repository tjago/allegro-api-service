package api.allegro.service;

import com.allegro.webapi.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

/**
 * Created by tjago on 2015-11-22.
 */
@Service
public class AllegroClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AllegroClient.class);

    @Value("${allegro.api.key}")
    private String ALLEGRO_API_KEY;

    @Autowired
    Converter converter;

    public List<AllegroItem> getAllegroItems(String categoryId, int itemsNumber) {

        if (ALLEGRO_API_KEY == null || ALLEGRO_API_KEY.length() == 0) {
            log.error("API key not existing!");
            throw new RuntimeException("no api key!");
        }

        ArrayOfString arrayofCategory = new ArrayOfString();
        arrayofCategory.getItem().add(categoryId);

        FilterOptionsType filterOptionsType = new FilterOptionsType();
        filterOptionsType.setFilterId("category");
        filterOptionsType.setFilterValueId( arrayofCategory );

//        FilterOptionsType[] filters = { filterOptionsType };

        ArrayOfFilteroptionstype arrayOfFilteroptionstype = new ArrayOfFilteroptionstype();
        arrayOfFilteroptionstype.getItem().add(filterOptionsType);

        DoGetItemsListRequest request = new DoGetItemsListRequest();
        request.setCountryId(1);
        request.setWebapiKey( ALLEGRO_API_KEY );
        request.setResultSize( itemsNumber );
        request.setFilterOptions( arrayOfFilteroptionstype );

        log.info("calling Allegro Api service " + Constants.DO_GET_ITEMS_LIST_REQUEST_OPERATION);

        DoGetItemsListResponse response = (DoGetItemsListResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        Constants.ALLEGRO_SERVICE_URI,
                        request,
                        new SoapActionCallback(Constants.ALLEGRO_SERVICE_URI + Constants.DO_GET_ITEMS_LIST_REQUEST_OPERATION)
                );
        log.info("Converting response to object [umarshalling] ");

        return converter.convertDoGetItemsListResponse(response);
    }

}
