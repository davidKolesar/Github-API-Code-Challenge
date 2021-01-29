package com.mycompany.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.view.DisplayContent;

public class DataSummaryService {
	DisplayContent displayContent = new DisplayContent();

	public int analyzeJobData(String responseData, String city) throws IOException {

		if(city == null || responseData == null) {
			return 0;
		}
		
		
		ArrayList<String> listOfLanguages = new ArrayList<String>();
		listOfLanguages.add("JavaScript");
		listOfLanguages.add("Java");
		listOfLanguages.add("C#");
		listOfLanguages.add("Python");
		listOfLanguages.add("Swift");
		listOfLanguages.add("Objective-C");
		listOfLanguages.add("Ruby");
		listOfLanguages.add("Kotlin");
		listOfLanguages.add("Go");
		listOfLanguages.add("C++");
		listOfLanguages.add("PHP");
		listOfLanguages.add(" C ");
		listOfLanguages.add(" C,");
		listOfLanguages.add(" C.");
		
		String[] individualJobs = responseData.split("\"id\":");
		Map<String, Double> languagesDetected = new HashMap<String, Double>();

		for (String jobDescription : individualJobs) {
			for (int i = 0; i < listOfLanguages.size(); i++) {
				if (jobDescription.contains(listOfLanguages.get(i))) {
					if (!languagesDetected.containsKey(listOfLanguages.get(i))) {
						languagesDetected.put(listOfLanguages.get(i), 1.0);
					} else {
						languagesDetected.put(listOfLanguages.get(i),
								languagesDetected.get(listOfLanguages.get(i)) + 1.0);
					}
				}
			}
		}


		//add all C jobs together 
		Double cAsList = languagesDetected.get("C,");
		Double cAsFinal = languagesDetected.get(" C.");
		Double cAsIndividual = languagesDetected.get(" C ");
		
		if(cAsList == null) {
			cAsList = 0.0;			
		}

		if(cAsFinal  == null) {
			cAsFinal  = 0.0;			
		}
		
		if(cAsIndividual == null) {
			cAsIndividual = 0.0;			
		}
				
			
		double totalC = cAsList + cAsFinal + cAsIndividual;		
		
		//create new entry
		languagesDetected.put("C", totalC);
		
		//delete out old
		languagesDetected.remove("C,");
		languagesDetected.remove("C.");
		languagesDetected.remove(" C ");
		
		displayContent.displayTotalResults(city, individualJobs.length - 1);
		
		
		for (String key : languagesDetected.keySet()) {

			double percentage = languagesDetected.get(key) / (individualJobs.length - 1);
			percentage = percentage * 100;
			int roundedPercent = (int) Math.round(percentage);
			displayContent.displayRoundedResults(roundedPercent, key);
		}
		
		return individualJobs.length - 1;
		
	
	}
}
