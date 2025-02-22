package com.allyssad;

public class Main {
    public static void main(String[] args) {
        // First Coffee object (Espresso)
        Coffee coffee1 = new Coffee(
                "Espresso", "Arabica", "Medium", 100, "Dark", "Colombia", false, 10,
                new String[]{"Chocolate", "Nutty"}, "French Press"
        );

        // Second Coffee object (Latte)
        Coffee coffee2 = new Coffee(
                "Latte", "Robusta", "Large", 100, "Medium", "Brazil", false, 5,
                new String[]{"Caramel", "Creamy"}, "Drip"
        );

        // Displaying details of coffee1 (Espresso)
        System.out.println("Coffee 1 Details:");
        System.out.println("Name: " + coffee1.name);
        System.out.println("Type: " + coffee1.type);
        System.out.println("Size: " + coffee1.size);
        System.out.println("Base Price: PHP " + coffee1.price);
        System.out.println("Roast Level: " + coffee1.roastLevel);
        System.out.println("Origin: " + coffee1.origin);
        System.out.println("Is Decaf: " + coffee1.isDecaf);
        System.out.println("Stock: " + coffee1.stock);
        System.out.println("Flavor Notes: " + String.join(", ", coffee1.flavorNotes));
        System.out.println("Brew Method: " + coffee1.brewMethod);
        System.out.println();

        // Displaying details of coffee2 (Latte)
        System.out.println("Coffee 2 Details:");
        System.out.println("Name: " + coffee2.name);
        System.out.println("Type: " + coffee2.type);
        System.out.println("Size: " + coffee2.size);
        System.out.println("Base Price: PHP " + coffee2.price);
        System.out.println("Roast Level: " + coffee2.roastLevel);
        System.out.println("Origin: " + coffee2.origin);
        System.out.println("Is Decaf: " + coffee2.isDecaf);
        System.out.println("Stock: " + coffee2.stock);
        System.out.println("Flavor Notes: " + String.join(", ", coffee2.flavorNotes));
        System.out.println("Brew Method: " + coffee2.brewMethod);
        System.out.println();

        // Calling methods on coffee1 (Espresso)
        System.out.println("\n=== Coffee 1 ===");
        System.out.println(coffee1.describe());
        coffee1.calculatePrice(coffee1.size);
        coffee1.updateStock(5);
        coffee1.checkStock();
        coffee1.addFlavor("Vanilla");
        coffee1.setDecaf(true);
        coffee1.changeRoastLevel("Light");
        coffee1.discount(15);

        // Calling methods on coffee2 (Latte)
        System.out.println("\n=== Coffee 2 ===");
        System.out.println(coffee2.describe());
        coffee2.calculatePrice(coffee2.size);
        coffee2.updateStock(-2);
        coffee2.checkStock();
        coffee2.addFlavor("Hazelnut");
        coffee2.setDecaf(false);
        coffee2.changeRoastLevel("Dark");
        coffee2.discount(10);

        // Displaying updated details of coffee1
        System.out.println("\nUpdated Coffee 1 Details:");
        System.out.println(coffee1.describe());
        System.out.println("Name: " + coffee1.name);
        System.out.println("Type: " + coffee1.type);
        System.out.println("Size: " + coffee1.size);
        System.out.println("Updated Price: PHP " + coffee1.price);
        System.out.println("Roast Level: " + coffee1.roastLevel);
        System.out.println("Origin: " + coffee1.origin);
        System.out.println("Is Decaf: " + coffee1.isDecaf);
        System.out.println("Stock: " + coffee1.stock);
        System.out.println("Flavor Notes: " + String.join(", ", coffee1.flavorNotes));
        System.out.println("Brew Method: " + coffee1.brewMethod);
        System.out.println();

        // Displaying updated details of coffee2
        System.out.println("\nUpdated Coffee 2 Details:");
        System.out.println(coffee2.describe());
        System.out.println("Name: " + coffee2.name);
        System.out.println("Type: " + coffee2.type);
        System.out.println("Size: " + coffee2.size);
        System.out.println("Updated Price: PHP " + coffee2.price);
        System.out.println("Roast Level: " + coffee2.roastLevel);
        System.out.println("Origin: " + coffee2.origin);
        System.out.println("Is Decaf: " + coffee2.isDecaf);
        System.out.println("Stock: " + coffee2.stock);
        System.out.println("Flavor Notes: " + String.join(", ", coffee2.flavorNotes));
        System.out.println("Brew Method: " + coffee2.brewMethod);
        System.out.println();
    }
}