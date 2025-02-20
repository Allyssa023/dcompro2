package com.allyssad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class CoffeeShop {

    // 2D array representing the coffee menu.
    // Each row contains a coffee type (String) and its price (String).
    // The first column (index 0) stores the coffee name, and the second column (index 1) stores its price.
    private static final String[][] COFFEE_MENU = {
            {"Espresso", "50.0"},
            {"Latte", "70.0"},
            {"Cappuccino", "65.0"},
            {"Mocha", "80.0"},
    };

    private static final double VAT_RATE = 0.12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String receipt = "\n---- Coffee Order Receipt ----\n";
        double total = 0.0;

        while (true) {
            displayMenu();
            System.out.print("Choose your coffee (1-" + COFFEE_MENU.length + ", or 0 to finish): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) {
                    break;
                }
                if (choice < 1 || choice > COFFEE_MENU.length) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine()); // This is better to avoid discarding next line character
                if (quantity < 1) {
                    System.out.println("Quantity must be at least 1. Please try again.");
                    continue;
                }

                double itemTotal = Double.parseDouble(COFFEE_MENU[choice - 1][1]) * quantity;
                total += itemTotal;
                receipt += String.format("%d x %s @ %.2f each = %.2f\n", quantity, Double.parseDouble(COFFEE_MENU[choice - 1][1]), Double.parseDouble(COFFEE_MENU[choice - 1][1]), itemTotal);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        double vat = total * VAT_RATE;
        double grandTotal = total + vat;
        receipt += "---------------------------\n";
        receipt += String.format("Subtotal: %.2f\n", total);
        receipt += String.format("VAT (12%%): %.2f\n", vat);
        receipt += String.format("Grand Total: %.2f\n", grandTotal);
        receipt += "---------------------------\n";

        System.out.println(receipt);
        saveReceiptToFile(receipt);
        scanner.close();
    }

    /**
     * Method to display the coffee menu to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Coffee Menu ---");
        for (int i = 0; i < COFFEE_MENU.length; i++) {
            System.out.println((i + 1) + ". " + COFFEE_MENU[i][0] + " - " + COFFEE_MENU[i][1] + " PHP");
        }
        System.out.println("0. Finish Order");
    }

    /**
     * Method to save the receipt to a file
     *
     * @param receipt The receipt to save
     */
    private static void saveReceiptToFile(String receipt) {
        File saveDir = new File("target/receipts");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        File receiptFile = new File(saveDir, "CoffeeReceipt.txt");
        try (FileWriter writer = new FileWriter(receiptFile)) {
            writer.write(receipt);
            System.out.println("\nReceipt saved to CoffeeReceipt.txt");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}