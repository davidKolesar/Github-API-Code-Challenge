package com.mycompany.controller;

import com.mycompany.dto.ConsoleIO;
import com.mycompany.view.DisplayContent;

public class ApplicationController {

	ConsoleIO consoleIO = new ConsoleIO();
	DisplayContent displayContent = new DisplayContent();

	public void init() {
		displayContent.displayTitleScreen();
		int userResponse = displayContent.displayMenu();
		processUserSelection(userResponse);
	}

	public void processUserSelection(int userResponse) {

		switch (userResponse) {
		case 1:
			// city ;
			break;
		case 2:
			// city ;
			break;
		case 3:
			// city ;
			break;
		case 4:
			// city ;
			break;
		case 5:
			// city ;
			break;
		case 6:
			// city ;
			break;
		case 7:
			// city ;
			break;
		case 8:
			// city ;
			break;
		case 9:
			displayContent.displayHelp();
			break;
		default:
			// invalid selection
		}
	}
}