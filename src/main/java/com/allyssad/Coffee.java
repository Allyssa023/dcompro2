package com.allyssad;

import java.util.ArrayList;
import java.util.Arrays;

public class Coffee {

    // Attributes of Coffee
    String name;
    String type;
    String size;
    double price;
    String roastLevel;
    String origin;
    boolean isDecaf;
    int stock;
    public ArrayList<String> flavorNotes;
    String brewMethod;

    /**
     * Constructor to initialize a Coffee object with specified attributes.
     *
     * @param name       The name of the coffee.
     * @param type       The type of coffee.
     * @param size       The size of the coffee.
     * @param price      The base price of the coffee.
     * @param roastLevel The roast level of the coffee.
     * @param origin     The origin of the coffee beans.
     * @param isDecaf    Indicates whether the coffee is decaffeinated.
     * @param stock      The quantity available in stock.
     * @param flavorNotes An array of flavor notes describing the taste.
     * @param brewMethod The method used to brew the coffee.
     */
    public Coffee(String name, String type, String size, double price, String roastLevel, String origin,
                  boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price; // Allow dynamic price input
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = new ArrayList<>(Arrays.asList(flavorNotes));
        this.brewMethod = brewMethod;
    }

    /**
     * Adjusts the price based on the selected size of the coffee.
     *
     * @param size The size of the coffee (Small, Medium, Large).
     */
    public void calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                this.price += 10; // Adjusts price for small size
                break;
            case "medium":
                this.price += 30; // Adjusts price for medium size
                break;
            case "large":
                this.price += 50; // Adjusts price for large size
                break;
            default:
                System.out.println("Invalid size. Keeping base price.");
        }
        System.out.println("Price of " + this.name + " (" + this.size + "): PHP " + this.price);
    }

    /**
     * Checks if the coffee is in stock and displays the current stock status.
     */
    public void checkStock() {
        System.out.println("Stock for " + this.name + ": " + (this.stock > 0 ? "Available" : "Out of stock"));
    }

    /**
     * Adds a new flavor note to the coffee's flavor profile.
     *
     * @param note The flavor note to be added (e.g., "Vanilla", "Caramel").
     */
    public void addFlavor(String note) {
        this.flavorNotes.add(note);
        System.out.println("Added flavor: " + note);
    }

    /**
     * Updates the stock quantity of the coffee.
     *
     * @param quantity The amount to increase or decrease the stock.
     */
    public void updateStock(int quantity) {
        this.stock += quantity;
        System.out.println("Updated stock for " + this.name + ": " + this.stock);
    }

    /**
     * Returns a description of the coffee, including its roast level and flavor notes.
     *
     * @return A formatted description of the coffee.
     */
    public String describe() {
        return "A " + this.roastLevel + " roast " + this.name + " with " + String.join(", ", this.flavorNotes) + " notes.";
    }

    /**
     * Updates whether the coffee is decaffeinated or not.
     *
     * @param isDecaf True if the coffee should be decaffeinated, false otherwise.
     */
    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
        System.out.println(this.name + " is now " + (this.isDecaf ? "decaffeinated" : "regular"));
    }

    /**
     * Changes the roast level of the coffee.
     *
     * @param newRoastLevel The new roast level (e.g., "Light", "Medium", "Dark").
     */
    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
        System.out.println("Roast level of " + this.name + " changed to " + this.roastLevel);
    }

    /**
     * Applies a discount to the coffee price based on a given percentage.
     *
     * @param percentage The discount percentage to apply.
     */
    public void discount(int percentage) {
        double discountAmount = (this.price * percentage) / 100;
        this.price -= discountAmount;
        System.out.println("Discount applied! New price of " + this.name + ": PHP " + this.price);
    }
}