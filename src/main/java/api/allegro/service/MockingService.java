package api.allegro.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by tjago on 2015-11-21.
 */

@Service
public class MockingService {

    private AtomicLong count = new AtomicLong();

    public List<AllegroItem> getAllegroSampleData() {

        List<AllegroItem> itemList = new ArrayList<>();

        itemList.add(new AllegroItem(
                count.incrementAndGet(),
                "http://img20.allegroimg.pl/photos/oryginal/54/84/52/03/5484520391",
                "http://allegro.pl/show_item.php?item=5484520391",
                "NOWY OFFICE 2010 dla FIRM BOX PL 2PC Fvat",
                4632,
                4));

        itemList.add(new AllegroItem(
                count.incrementAndGet(),
                "http://0.allegroimg.pl/original/13/57/57/33/84/5757338480",
                "http://allegro.pl/show_item.php?item=5757338480",
                "Smartfon LG Nexus 5X 5.2'FHD 32GB 12MP LTE And6.0",
                14432,
                3 ));

        itemList.add(new AllegroItem(
                count.incrementAndGet(),
                "http://9.allegroimg.pl/original/06/58/09/22/39/5809223993",
                "http://allegro.pl/forma-blacha-do-tarty-28x3cm-i5809223993.html",
                "FORMA BLACHA DO TARTY 28x3cm",
                110916,
                5));


        return itemList;
    }
}
