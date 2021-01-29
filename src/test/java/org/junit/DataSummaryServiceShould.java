package org.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.Random;

import org.junit.jupiter.api.Test;

import com.mycompany.services.DataSummaryService;

class DataSummaryServiceShould {

	DataSummaryService dataSummaryService = new DataSummaryService();

	@Test
	public void exist() {
		assertNotNull(dataSummaryService);
	}

	@Test
	public void handleNullResponseData() throws IOException {
		int response = dataSummaryService.analyzeJobData(null, "testCity");
		assertEquals(response, 0);
	}

	@Test
	public void handleNullCity() throws IOException {
		int response = dataSummaryService.analyzeJobData("responesData", null);
		assertEquals(response, 0);
	}

	@Test
	public void differentiateJavaVersusJavaScript() throws IOException {
		int totalJobs = 0;
		int expectedJobs = 2;
		String testJobData = "\"id\": must know JavaScript \"id\": must know Java";
		totalJobs = dataSummaryService.analyzeJobData(testJobData, "test City");
		assertEquals(expectedJobs, totalJobs);
	}
	
	//The next step in testing is to test job % accuracy
	//@Test
	public void differentiateCapitalC() throws IOException {
		int totalJobs = 0;
		int expectedJobs = 2;
		String testJobData = "\"id\": must know C \"id\": CccCcCc";
		totalJobs = dataSummaryService.analyzeJobData(testJobData, "test City");
		assertEquals(expectedJobs, totalJobs);
	}
	
	@Test
	public void splitOnId() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String id = "\"id\":";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		int totalJobs = 0;
		int iterations = rnd.nextInt(10 - 1 + 1) + 1;

		for (int i = 0; i < iterations; i++) {
			salt.append(id);
			int index = rnd.nextInt(5 - 1 + 1) + 1;
			while (index < 10) {
				salt.append(SALTCHARS.charAt(index));
				index++;
			}
			salt.append(" ");
		}

		String testJobData = salt.toString();
		try {
			totalJobs = dataSummaryService.analyzeJobData(testJobData, "test City");
		} catch (IOException e) {
			System.out.println("Could not complete splitOnId test!");
			e.printStackTrace();
		}
		assertEquals(totalJobs, iterations);
	}

}
