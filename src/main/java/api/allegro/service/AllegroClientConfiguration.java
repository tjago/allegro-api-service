package api.allegro.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tjago on 2015-11-22.
 */

@Configuration
public class AllegroClientConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Map<String, String> properties = new HashMap<>();
        properties.put("jaxb.encoding", "UTF-8");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.allegro.webapi");
        marshaller.setMarshallerProperties( properties );
        return marshaller;
    }

    @Bean
    public AllegroClient allegroClient(Jaxb2Marshaller marshaller) {
        Converter converter = new Converter();
        AllegroClient client = new  AllegroClient(converter);
        client.setDefaultUri(Constants.ALLEGRO_SERVICE_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
