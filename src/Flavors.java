import java.util.Scanner;

public class Flavors extends BaseOrder {
    private String selectedFlavor;
    private String selectedToppings;

    public Flavors(Scanner scanner) {
        super(scanner, 2.99);  // Call to super constructor
    }

    @Override
    public double placeOrder() {
        return placeOrder(true);  // Simplifies the default call
    }

    // Overloaded method to optionally skip cup or cone question
    public double placeOrder(boolean askCupCone) {
        this.selectedFlavor = askFlavor();  // Get flavor from user
        if (!isValidFlavor(this.selectedFlavor)) {
            System.out.println("Invalid flavor selected.");
            return 0;
        }

        if (askCupCone) {
            String servingType = askCupOrCone();
            System.out.println("You selected a " + servingType + ".");
        }

        this.selectedToppings = askToppings();
        double cost = calculateTotalCost();
        incrementOrderCount();  // Increment the order count
        return applyDiscount(cost);
    }

    // Method to prompt user for flavor selection
    private String askFlavor() {
        System.out.println("Our shop is best known for our vanilla flavor and house-made waffle cone!");
        System.out.println("But you may choose from the following flavors: Vanilla, Chocolate, Strawberry, Cookie Dough, Cotton Candy");
        return scanner.nextLine().toLowerCase();  // Return the user's flavor choice
    }

    private String askCupOrCone() {
        System.out.println("Would you like your ice cream in a cup or a cone?");
        String choice = scanner.nextLine().toLowerCase();
        return (choice.equals("cup") || choice.equals("cone")) ? choice : "cone";  // Defaults to 'cone'
    }

    private String askToppings() {
        System.out.println("Please choose toppings (separated by commas), or type 'none' for no toppings:");
        System.out.println("Options: None, Rainbow sprinkles, Chocolate sprinkles, Chocolate chips, Oreos, M&Ms, Gummy bears, Reese's pieces");
        String toppingsChoice = scanner.nextLine().toLowerCase();
        if (!toppingsChoice.equals("none")) {
            String[] toppings = toppingsChoice.split(",");
            for (String topping : toppings) {
                switch (topping.trim()) {
                    case "rainbow sprinkles":
                    case "chocolate sprinkles":
                    case "chocolate chips":
                    case "oreos":
                    case "m&ms":
                    case "gummy bears":
                    case "reese's pieces":
                        break; // Valid topping, continue
                    default:
                        System.out.println("Sorry, we don't serve '" + topping.trim() + "' topping at our shop.");
                        return "none"; // Invalid topping, return none
                }
            }
        }
        return toppingsChoice;
    }

    private double applyDiscount(double cost) {
        double discount = (BaseOrder.getOrderCount() > 10) ? 0.1 : 0;
        return Math.round(cost * (1 - discount) * 100) / 100.0;
    }

    private boolean isValidFlavor(String flavor) {
        return flavor.equals("vanilla") || flavor.equals("chocolate") || flavor.equals("strawberry") ||
                flavor.equals("cookie dough") || flavor.equals("cotton candy");
    }

    private double calculateTotalCost() {
        double cost = getBasePrice();
        if (!this.selectedToppings.equalsIgnoreCase("none")) {
            String[] splitToppings = this.selectedToppings.split(",");
            cost += 0.25 * splitToppings.length;
        }
        return cost;
    }
}

