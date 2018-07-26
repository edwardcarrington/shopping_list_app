package grandcircus.bonus20lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class bonus20 {

	public static void main(String[] args) {

		// key is item as a String
		// value is price as a double

		HashMap<String, Double> inventory = new HashMap<>();
		ArrayList<String> shoppingCart = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		String cont;

		// greeting
		System.out.println(
				"\nWelcome to Eddy's Fruits located in shed \"3\" within Detroit's wonderful Easern Market!\n");

		// fills the inventory
		inventory = fillInventory(inventory);

		// displays the inventory
		displayInventory(inventory);

		System.out.println();

		do {
			// scanner, inventory, prompt
			// could return a String, then add to shoppingCart
			String prompt = "What would you like to order today?";
			String newItem = enterItem(scnr, inventory, prompt);
			shoppingCart.add(newItem);

			System.out.println("Would you like to add another item? (y/n) ");
			cont = scnr.nextLine();
			cont = cont.toLowerCase();

		} while (cont.startsWith("y"));

		// if no, display:

		System.out.println("\nThanks for your order!\nThis is what you've got:");
		System.out.println(shoppingCart);

		// average(); this displays average price of all items
		average(shoppingCart, inventory);

		// highest(); this displays highest price item
		highest(shoppingCart, inventory);

		// lowest(); this display lowest price item
		lowest(shoppingCart, inventory);
	}

	private static void lowest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double lowest = 0.0;

		for (String fruit : shoppingCart) {

			if (lowest < inventory.get(fruit)) {
				lowest = inventory.get(fruit);
			}

		}

	}

	private static void highest(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double highest = 0.0;

		for (String fruit : shoppingCart) {

			if (highest < inventory.get(fruit)) {
				highest = inventory.get(fruit);
			}

		}

	}

	private static void average(ArrayList<String> shoppingCart, HashMap<String, Double> inventory) {
		double sum = 0;// the total price, added together
		int count = 0; // the number of individual items
		for (String fruit : shoppingCart) {

			// sum get from the inventory,
			// the "value" of the "key" in this case fruit!
			sum += inventory.get(fruit);
			count++;

		}

		System.out.println("The average price that you've paid for these items comes to: " + sum / count);
	}

	private static String enterItem(Scanner scnr, HashMap<String, Double> inventory, String prompt) {
		String userInput;

		System.out.println(prompt);

		userInput = scnr.nextLine();

		if (inventory.containsKey(userInput) == true) { // is a boolean method, no need to create a boolean
			System.out.println("\nConfirmation! " + userInput + " has been added to your cart!");

			// else repeat the method
		} else {
			System.out.println("Sorry, " + userInput + " isn't in season yet!-(");
			enterItem(scnr, inventory, prompt);

		}
		return userInput;
	}

	private static HashMap<String, Double> fillInventory(HashMap<String, Double> inventory) {
		inventory.put("apple", 0.99);
		inventory.put("banana", 0.59);
		inventory.put("cauliflower", 1.59);
		inventory.put("dragonfruit", 2.19);
		inventory.put("elderberry", 1.79);
		inventory.put("figs", 2.09);
		inventory.put("grapefruit", 1.99);
		inventory.put("honeydew", 3.49);
		return inventory;
	}

	private static void displayInventory(HashMap<String, Double> inventory) {
		// we want to use the for loop
		// String format = "%s\t\t%s";
		String format = "%-15s  %s%n";
		System.out.println("Check out the items that we currently have for sale today.");
		System.out.println();
		System.out.printf(format, "Item", "Price");
		System.out.println();
		System.out.println("=======================\n");

		// loops through inventory by key (which is the list of fruits
		for (String fruit : inventory.keySet()) {

			// this line prints out for each individual fruit
			System.out.printf(format, fruit, inventory.get(fruit));
			// System.out.println(fruit + " " + inventory.get(fruit));
		}

	}

}
