package com.mycompany.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.mycompany.services.DataSummaryService;
import com.mycompany.view.DisplayContent;

public class GithubController {

	DisplayContent displayContent = new DisplayContent();
	DataSummaryService dataSummaryService = new DataSummaryService();

	public int getJobInformation(String cityQuery, String cityName ) throws IOException {

		if(cityQuery == null || cityName == null) {
			return 0;
		}
		
		
	String concatinatedURL = "https://jobs.github.com/positions.json?description=&location=" + cityQuery;
		URL cityURL = new URL(concatinatedURL);

		String readLine = null;
		HttpURLConnection connection = (HttpURLConnection) cityURL.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
			// in.readLine returns null when there's nothing else in the line
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			
			//do not analyze data if no results are found
			if(response.toString().equals("[]")) {
				displayContent.displayNoResults();
				return 1;
			}
			dataSummaryService.analyzeJobData(response.toString(), cityName);
			return 1;
		}

		return 0;
	}

}