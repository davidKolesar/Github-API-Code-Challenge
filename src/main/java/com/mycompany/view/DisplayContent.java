package com.mycompany.view;

import java.io.IOException;

import com.mycompany.controller.ApplicationController;
import com.mycompany.dto.ConsoleIO;

public class DisplayContent {

	ConsoleIO consoleIO = new ConsoleIO();
	
	public void displayTitleScreen() {
		consoleIO.printASCIIArt("Validic");
		consoleIO.displayString("");
		consoleIO.displayString("Programming Language Trends of 2021");
		consoleIO.displayString("");
		consoleIO.displayString("Created by David Kolesar");
		consoleIO.displayString("");
		consoleIO.pressAnyKeyToConitue();
		consoleIO.clearScreen();
	}

	public int displayMenu() {
		consoleIO.displayString("");
		consoleIO.displayString("1. Boston");
		consoleIO.displayString("2. San Francisco");
		consoleIO.displayString("3. Los Angeles");
		consoleIO.displayString("4. Denver");
		consoleIO.displayString("5. Boulder");
		consoleIO.displayString("6. Chicago");
		consoleIO.displayString("7. New York City");
		consoleIO.displayString("8. Raleigh");
		consoleIO.displayString("");
		consoleIO.displayString("9. Help");
		consoleIO.displayString("");
		consoleIO.displayString("");
		return consoleIO.getIntRange(
				"Input the number corresponding to the city you would like information about. Press '9' for help.", 9,
				0);
	}

	public void displayHelp() throws IOException {
		consoleIO.clearScreen();
		consoleIO.displayString("This program displays programming trends in employment listings for a given city.");
		consoleIO.displayString("");
		consoleIO.displayString("To operate this program, input the number correlating to the city in which you are inquiring and then press the 'enter' key.");
		consoleIO.displayString("");
		consoleIO.displayString("Many listings mention more than one programming language. For this reason, you may see percentages that add up beyond 100%. ");
		consoleIO.pressAnyKeyToConitue();
	}

	public void displayTotalResults(String city, int totalJobs) {
		consoleIO.clearScreen();
		consoleIO.displayString("In " + city + " :  ");
		consoleIO.displayString("There are a total of " + totalJobs + " listings.");
		consoleIO.displayString("");
	}

	public void displayRoundedResults(int roundedPercent, String language) {
		consoleIO.displayString(roundedPercent + "% of all available listings refer to " + language);
	}

	public void displayNoResults() throws IOException {
		consoleIO.clearScreen();
		consoleIO.displayString("No results were found for this city!");
		promptMenuReturn();
	}

	
	public void promptMenuReturn() throws IOException {
		ApplicationController applicationController = new ApplicationController();
		consoleIO.displayString("");
		consoleIO.pressAnyKeyToConitue();
		consoleIO.clearScreen();
		consoleIO.displayString("");
		applicationController.returnToMenu();
	}


}
