package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.sql.Timestamp;
import java.time.Instant;

public class Program {


	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		File csv = new File("vendingmachine.csv");
		HashMap<String, Items> itemsHashMap = convertFile(csv);

		VendingMachine vendingMachine = new VendingMachine(itemsHashMap);
		boolean isOn = true;

		File file = new File("SalesLog.txt");

		if (file.exists()) {
			file.delete();
		}

		try (PrintWriter printer = new PrintWriter(file)) {
			printer.println("   DATE " + "         TIME "  + "        ACTION " + " AMOUNT " + " BALANCE");

		} catch (FileNotFoundException f) {
			System.out.println("Beep");
		}
		


		System.out.println("Welcome to TECK vending machine! ");

		while (isOn) {
			System.out.println();
			System.out.println();
			System.out.println("Please select an option");
			System.out.println("Current money provided: $" + vendingMachine.getBalance());
			System.out.println();

			System.out.println("Option 1: Item list");
			System.out.println("Option 2: Purchase");
			System.out.println("Option 3: Exit ");


			String inputString = userInput.nextLine();
			int input = 0;

			try {
				input = Integer.parseInt(inputString);
			} catch (NumberFormatException e) {
				System.out.println("Not a valid input, Try again.");
				input = 0;
			}



			if (input == 1) { while (input != 5) {

				System.out.println(vendingMachine.listItems());
				System.out.println("Pick 5 to go back");

				 inputString = userInput.nextLine();
				 input = 0;

				try {
					input = Integer.parseInt(inputString);
				} catch (NumberFormatException e) {
					System.out.println("Not a valid input, Try again.");
					input = 0;
				}


				if (input == 1) {
					System.out.println(vendingMachine.listRow(1));
				}
				if (input == 2) {
					System.out.println(vendingMachine.listRow(2));

				}

				if (input == 3) {
					System.out.println(vendingMachine.listRow(3));

				}

				if (input == 4) {
					System.out.println(vendingMachine.listRow(4));

				}

				if (input == 5) {
					continue;
				}
			}

			}

			if (input == 2) {
				while (input != 4) {
					System.out.println("Current money provided: $" + vendingMachine.getBalance());
					System.out.println();
					System.out.println("Please select an option");
					System.out.println("(1) Feed Money");
					System.out.println("(2) Select Product");
					System.out.println("(3) Finish Transaction");
					System.out.println("(4) To go back to menu");

					inputString = userInput.nextLine();
					input = 0;

					try {
						input = Integer.parseInt(inputString);
					} catch (NumberFormatException e) {
						System.out.println("Not a valid input, Try again.");
						input = 0;
					}

					if (input == 1) {
						System.out.println("Please enter your money: ");
						double addMoney = Double.parseDouble(userInput.nextLine());
						vendingMachine.feedMoney(addMoney);
						updateSalesLog(file, "Feed Money", addMoney, vendingMachine.getBalance());
					}
					if (input == 2) {
						System.out.println("Please enter the slot location: ");
						String slotLocation = userInput.nextLine();
						System.out.println(vendingMachine.dispenseItem(slotLocation));
						updateSalesLog(file, " Bought " + itemsHashMap.get(slotLocation).getName(), itemsHashMap.get(slotLocation).getPrice(), vendingMachine.getBalance());
					}
					if (input == 3) {
						System.out.println("Thank you for using TECK vending machine");
						updateSalesLog(file, "Exit/Get change", vendingMachine.getBalance(), 0);
						System.out.println(vendingMachine.returnChange());
					}
				}
			}

			if (input == 3) {
				System.out.println("Thank you for using TECK vending machine");
				updateSalesLog(file, "Exit/Get change", vendingMachine.getBalance(), 0);
				System.out.println(vendingMachine.returnChange());
				continue;
			}

			if (input == 69) {
				isOn = false;
			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();


		}
		System.out.println("Thanks for using TECK vending machine.");
		System.out.println("Goodnight");

		//Display everything that happens
		//fix if something bad happens
		//log thing







	}

	public static void addToMap(Items item, HashMap<String, Items> hmp, String slotLocation) {
		hmp.put(slotLocation, item);
	}

	public static BigDecimal convertToBigDecmial(double num) {

		BigDecimal number = new BigDecimal(num);

		return (number);

	}

	public static void updateSalesLog(File file, String action, double payage, double balance) {
		Timestamp timestamp = Timestamp.from(Instant.now());



		try (FileWriter writer = new FileWriter(file, true)) {
			writer.write(timestamp + " " + action + " " + payage + " " + balance + " \n");

		} catch (IOException f) {
			System.out.println("Beep");
		}

	}

	public static int checkString() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input2 = scanner.nextLine();

			try {
				int input = Integer.parseInt(input2);
				return input;
			} catch (NumberFormatException e) {
				System.out.println("Not a valid input, Try again.");
			}
		}

	}

	public static HashMap<String, Items> convertFile(File file) {
		String lineOfText  = "";
		String[] array = new String[4];
		HashMap<String, Items> hmp = new HashMap<>();


		try (Scanner reader = new Scanner(file)) {
			while ((reader.hasNextLine())) {
				lineOfText = reader.nextLine();
				if (lineOfText.contains("Chip")) {
					lineOfText = lineOfText.toString();
					array = lineOfText.split(",");
					double price = Double.parseDouble(array[2]);
					 hmp.put(array[0], new Chips(array[1], price, array[0], array[3], 5));
				}
				if (lineOfText.contains("Gum")) {
					lineOfText = lineOfText.toString();
					array = lineOfText.split(",");
					double price = Double.parseDouble(array[2]);
					hmp.put(array[0], new Chips(array[1], price, array[0], array[3], 5));
				}
				if (lineOfText.contains("Drink")) {
					lineOfText = lineOfText.toString();
					array = lineOfText.split(",");
					double price = Double.parseDouble(array[2]);
					hmp.put(array[0], new Chips(array[1], price, array[0], array[3], 5));
				}
				if (lineOfText.contains("Candy")) {
					lineOfText = lineOfText.toString();
					array = lineOfText.split(",");
					double price = Double.parseDouble(array[2]);
					hmp.put(array[0], new Chips(array[1], price, array[0], array[3], 5));
				}
			}

		} catch (FileNotFoundException f) {
			System.out.println("File not found");
		}
		return hmp;

	}

}
