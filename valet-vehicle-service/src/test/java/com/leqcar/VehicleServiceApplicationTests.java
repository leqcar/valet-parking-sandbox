package com.leqcar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {
	}

	@Test
	public void hasHalLinks() {
		ResponseEntity<String> entity = new TestRestTemplate().getForEntity(
				"http://localhost:"+ this.port + "/profile", String.class);

		assertEquals(entity.getStatusCode(), HttpStatus.OK);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
		assertThat(entity.getBody()).isNotEmpty();
		assertThat(entity.getBody()).contains("\"_links\"");
	}
}
