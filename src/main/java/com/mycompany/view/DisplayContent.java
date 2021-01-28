package com.mycompany.view;

import com.mycompany.dto.ConsoleIO;

public class DisplayContent {

	ConsoleIO consoleIO = new ConsoleIO();	
	DisplayContent displayContent = new DisplayContent();

	public void displayTitleScreen() {
		consoleIO.printASCIIArt("Valadic");
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
		return consoleIO.getIntRange("Input the number corresponding to the city you would like information about. Press '9' for help.", 1, 0);
	}
	
	public void displayHelp() {
		consoleIO.clearScreen();
		consoleIO.displayString("This program displays programming trends in employment for a given city.");
		consoleIO.displayString("");
		consoleIO.displayString("To operate this program, input the number correlating to the city in which you are inquiring and then press the 'enter' key.");
		consoleIO.displayString("");
	}
	
}
