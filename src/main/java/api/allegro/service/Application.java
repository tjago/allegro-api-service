package api.allegro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    AllegroCatsComponent allegroCatsComponent;

    @Autowired
    AllegroClient allegroClient;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void getCats() {
        log.info("doing PostConstruct jobs...");

        allegroCatsComponent.setCatsList(allegroClient.getMainAllegroCategories());
    }
}

//TODO add random category selection