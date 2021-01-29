package org.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.mycompany.controller.GithubController;

class GithubControllerShould {
	GithubController gitHubController = new GithubController();


	@Test
	public void handleNullCityQuery() throws IOException {
		int returnValue = gitHubController.getJobInformation(null, "Test City");
		assertEquals(returnValue, 0);
	}
	
	@Test
	public void handleNullCityName() throws IOException {
		int returnValue = gitHubController.getJobInformation("TestCity", null);
		assertEquals(returnValue, 0);
	}

	@Test
	public void handleNullCityNameAndQuery() throws IOException {
		int returnValue = gitHubController.getJobInformation(null, null);
		assertEquals(returnValue, 0);
	}

	@Test
	public void handleImpossibleQuery() throws IOException {
		int returnValue = gitHubController.getJobInformation("Fake City", "Made Up City");
		assertEquals(returnValue, 0);
	}

	@Test
	public void handleFakeCity() throws IOException {
		int returnValue = gitHubController.getJobInformation("FakeCity", "Made Up City");
		assertEquals(returnValue, 1);
	}

	
}
