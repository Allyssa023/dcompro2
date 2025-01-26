package com.allyssad;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Define a constant for the folder where the message files will be saved.
    static final String FOLDER = "target/message";

    public static void main(String[] args) {
        // Conversion constant for KM to MI
        final double MILES_TO_KM = 0.621371;

        // Create a scanner object to read user input
        Scanner haha = new Scanner(System.in);

        // Prompt the user to enter their first and last name
        System.out.print("Enter first name: ");
        String firstName = haha.nextLine();
        System.out.print("Enter last name: ");
        String lastName = haha.nextLine();
        System.out.println("Hello " + firstName + " " + lastName);

        // Simple calculator: Get two numbers and an operator (+, -, *, /) from the user
        System.out.print("\nEnter first number: ");
        int num1 = haha.nextInt();
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = haha.next().charAt(0); // Read a single character for the operator
        System.out.print("Enter second number: ");
        int num2 = haha.nextInt();

        double result = 0; // Result is stored as a double to handle division properly
        boolean validOperation = true; // Flag to track if the operation is valid

        // Perform the operation based on the operator
        switch (operator) {
            case '+': // Addition
                result = num1 + num2;
                break;
            case '-': // Subtraction
                result = num1 - num2;
                break;
            case '*': // Multiplication
                result = num1 * num2;
                break;
            case '/': // Division
                if (num2 != 0) { // Ensure no division by zero
                    result = (double) num1 / num2; // Perform floating-point division
                } else {
                    System.out.println("Error! Division by zero is not allowed.");
                    validOperation = false; // Mark the operation as invalid
                }
                break;
            default: // Handle invalid operators
                System.out.println("Invalid operator used");
                validOperation = false;
        }

        // If the operation was valid, display the result
        if (validOperation) {
            System.out.println("The result is: " + result);
        }

        // Convert a distance in KM to MI
        System.out.print("\nEnter a distance in km: ");
        double km = haha.nextDouble();
        double miles = km * MILES_TO_KM; // Conversion
        System.out.println(km + " km is " + miles + " mi");

        // Loop from 1 to 10
        System.out.print("\nEnter a number: ");
        int number = haha.nextInt();
        System.out.println("Looping through numbers 1 to 10: ");
        for (int i = 1; i <= number; i++) {
            System.out.println(i); // Print each number
        }

        // Reverse a word entered by the user
        haha.nextLine(); // Consume the newline character left by nextInt()
        System.out.print("\nEnter a word: ");
        String word = haha.nextLine();
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i); // Build the reversed word character by character
        }
        System.out.println("The word in reverse order: " + reversedWord);

        // Save a user-provided message to a file
        System.out.print("\nEnter a message: ");
        String message = haha.nextLine();
        System.out.println("The message is saved in target/message.txt");

        // Call the method to save the message to a file
        saveToFile(firstName + "message.txt", message);
    }

    // Method to save a message to a file
    public static void saveToFile(String fileName, String message) {
        // Create the folder where the file will be saved
        File folder = new File(FOLDER);
        if (!folder.exists()) { // Check if the folder already exists
            folder.mkdirs(); // Create the folder if it doesn't exist
        }

        // Create a file object for the message file
        File messageFile = new File(folder, fileName);
        try (FileWriter fr = new FileWriter(messageFile)) { //To ensure the writer is closed
            fr.write(message); // Write the message to the file
        } catch (IOException e) { // Handle any IO exceptions
            throw new RuntimeException(e); // Re-throw the exception as a runtime exception
        }
    }
}