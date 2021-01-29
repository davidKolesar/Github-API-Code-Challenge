package com.mycompany.controller;

import java.io.IOException;

import com.mycompany.dto.ConsoleIO;
import com.mycompany.services.DataSummaryService;
import com.mycompany.view.DisplayContent;

public class ApplicationController {

	ConsoleIO consoleIO = new ConsoleIO();
	DisplayContent displayContent = new DisplayContent();
	GithubController controller = new GithubController();
	DataSummaryService dataSummaryService = new DataSummaryService();

	public void init() throws IOException {
		displayContent.displayTitleScreen();
		int userResponse = displayContent.displayMenu();
		processUserSelection(userResponse);
	}

	public void returnToMenu() throws IOException {
		int userResponse = displayContent.displayMenu();
		processUserSelection(userResponse);
	}

	
	public void processUserSelection(int userResponse) throws IOException {

		switch (userResponse) {
		case 1:
			controller.getJobInformation("boston", "Boston");
			displayContent.promptMenuReturn();
			break;
		case 2:
			controller.getJobInformation("san+francisco", "San Francisco");
			displayContent.promptMenuReturn();
			break;
		case 3:
			controller.getJobInformation("los+angeles", "Los Angeles");
			displayContent.promptMenuReturn();
			break;
		case 4:
			controller.getJobInformation("denver", "Denver");
			displayContent.promptMenuReturn();
			break;
		case 5:
			controller.getJobInformation("boulder", "Boulder");
			displayContent.promptMenuReturn();
			break;
		case 6:
			controller.getJobInformation("chicago", "Chicago");
			displayContent.promptMenuReturn();
			break;
		case 7:
			controller.getJobInformation("new+york", "New York City");
			displayContent.promptMenuReturn();
			break;
		case 8:
			controller.getJobInformation("raleigh", "Raleigh");
			displayContent.promptMenuReturn();
			break;
		case 9:
			displayContent.displayHelp();
			displayContent.promptMenuReturn();
			break;
		default:
			// invalid selection
		}
	}
}