package api.allegro.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {
	@Autowired
	AllegroClient allegroClient;

	@Before
	public void contextLoads() {
	}

	@Test
//	@PreAuthorize("authenticated")
	public void getAllgeroItems() {
		List<AllegroItem> items = allegroClient.getAllegroItems(Constants.CATEGORY_KSIAZKI_I_KOMIKSY_ID, 1);
		assertTrue(items.size() > 0);
	}
}
