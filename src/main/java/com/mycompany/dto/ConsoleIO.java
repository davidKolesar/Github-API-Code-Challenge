package com.mycompany.dto;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * Handles validation of user input
 *
 * Created by David Kolesar
 * 
 */
public class ConsoleIO {

	public int getInt(String prompt) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		int userInt = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();

				userInt = Integer.parseInt(input);

				valid = true;

			} catch (NumberFormatException e) {
				System.out.println("Enter an integer: ");
			}

		}
		return userInt;
	}

	public int getIntRange(String prompt, int max, int min) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		int userInt = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();

				userInt = Integer.parseInt(input);

				if (userInt > max) {
					System.out.println("Enter an integer less than or equal to " + max + ": ");
				} else if (userInt < min) {
					System.out.println("Enter an integer greater than or equal to " + min + ": ");
				} else {
					valid = true;
				}

			} catch (NumberFormatException e) {
				System.out.println("Enter an integer: ");
			}

		}
		return userInt;
	}

	public String getString(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		String userString = sc.nextLine();
		return userString;
	}

	public float getFloat(String prompt) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		float userFloat = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();

				userFloat = Float.parseFloat(input);

				valid = true;

			} catch (NumberFormatException e) {
				System.out.println("Enter a float: ");
			}

		}
		return userFloat;
	}

	public float getFloatRange(String prompt, float max, float min) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		float userFloat = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();

				userFloat = Float.parseFloat(input);

				if (userFloat > max) {
					System.out.println("Enter a float less than or equal to " + max + ": ");
				} else if (userFloat < min) {
					System.out.println("Enter a float greater than or equal to " + min + ": ");
				} else {
					valid = true;
				}

			} catch (NumberFormatException e) {
				System.out.println("Enter a float: ");
			}
		}
		return userFloat;
	}

	public double getDouble(String prompt) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		double userDouble = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();
				if (input.equals("NaN")) {
					System.out.println("NaN is not a number");
					String retry = ("Please enter a number.");
					getDouble(retry);
				}
				userDouble = Double.parseDouble(input);

				valid = true;

			} catch (NumberFormatException e) {
				System.out.println("Enter a double: ");
			}
		}
		return userDouble;
	}

	public double getDoubleRange(String prompt, double max, double min) {

		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		double userDouble = 0;

		System.out.println(prompt);

		while (!valid) {
			try {
				String input = sc.nextLine();

				userDouble = Double.parseDouble(input);

				if (userDouble > max) {
					System.out.println("Enter a double less than or equal to " + max + ": ");
				} else if (userDouble < min) {
					System.out.println("Enter a double greater than or equal to " + min + ": ");
				} else {
					valid = true;
				}

			} catch (NumberFormatException e) {
				System.out.println("Enter a double: ");
			}
		}
		return userDouble;
	}

	public void displayString(String prompt) {
		System.out.println(prompt);
	}

	public void displayInt(int prompt) {
		System.out.println(prompt);
	}

	public void displayFloat(float prompt) {
		System.out.println(prompt);
	}

	public void displayDouble(Double prompt) {
		System.out.println(prompt);
	}

	public void displayLocalDate(LocalDate prompt) {
		System.out.println(prompt);
	}

	public String getDate(String prompt) {
		DateFormat df = new SimpleDateFormat("MMDDYYYY");
		Scanner sc = new Scanner(System.in);
		boolean valid = true;
		String x = null;
		while (valid) {
			try {
				System.out.println(prompt);
				x = sc.nextLine();
				df.setLenient(false);
				Date d = df.parse(x);
				valid = false;
			} catch (ParseException e) {
				System.out.println("\n" + "Please enter date in valid format(MMDDYYYY)" + "\n");
			}
		}
		return x;
	}

	public LocalDate getLocalDate(String prompt) {

		Scanner sc = new Scanner(System.in);

		String userInput = "";
		int month = 1;
		int day = 1;
		int year = 1;

		System.out.println(prompt);

		// Get the Month
		boolean needValidMonth = true;

		while (needValidMonth) {

			System.out.print("Enter the Month (MM) : ");
			userInput = sc.nextLine();

			try {
				month = Integer.parseInt(userInput);

				if (month <= 12 && month >= 1) {
					needValidMonth = false;
				} else {
					System.out.println("Please enter a number between 1 and 12.");
				}

			} catch (NumberFormatException ex) {
				System.out.println("You have to enter a number. Please try again.");
			}

		}

		// Get the Day
		boolean needValidDay = true;

		while (needValidDay) {

			System.out.print("Enter the day (DD) : ");
			userInput = sc.nextLine();

			try {

				day = Integer.parseInt(userInput);

				if (day <= 31 && day >= 1) {
					needValidDay = false;
				} else {
					System.out.println("Please enter a number between 01 and 31.");
				}

			} catch (NumberFormatException ex) {
				System.out.println("You have to enter a number. Please try again.");
			}
		}

		// Get the Year
		boolean needValidYear = true;

		while (needValidYear) {

			System.out.print("Enter the year (YYYY): ");
			userInput = sc.nextLine();

			try {

				year = Integer.parseInt(userInput);

				if (year <= 9999 && year >= 0) {
					needValidYear = false;
				} else {
					System.out.println("Please enter a number between 0 and 9999.");
				}
			} catch (NumberFormatException ex) {
				System.out.println("You have to enter a number. Please try again.");
			}
		}

		LocalDate returnDate = LocalDate.of(year, month, day);

		return returnDate;
	}

	public void printASCIIArt(String textToDisplay) {

		int allColors = -16777216;
		int width = 100;
		int height = 30;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setFont(new Font("SansSerif", Font.BOLD, 14));

		Graphics2D graphics = (Graphics2D) graphic;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(textToDisplay, 10, 20);

		// Draw image against *
		for (int y = 0; y < height; y++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int x = 0; x < width; x++) {

				stringBuilder.append(image.getRGB(x, y) == allColors ? " " : "$");
			}

			if (stringBuilder.toString().trim().isEmpty()) {
				continue;
			}

			System.out.println(stringBuilder);
		}
	}

	public void pressAnyKeyToConitue() {
		System.out.print("Press any key to continue . . . ");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	public void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException | IOException e) {
			System.out.println("");
			System.out.println("Failed to clear screen.");
			System.out.println("");
			e.printStackTrace();
		}
		
		//Handles Linux Terminal
	    System.out.print("\033[H\033[2J");//ANSI escape codes, followed by home.
	    System.out.flush();  
	}
}
