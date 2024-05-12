import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Flavors flavor1 = new Flavors(); // Ensure this class is correctly defined elsewhere
        MilkshakeOrder milkshakeOrder = new MilkshakeOrder(input);

        boolean continueOrdering = true;
        double totalCost = 0.0;

        while (continueOrdering) {
            System.out.println("Welcome to IS147 Ice Cream Shop");
            System.out.println("Below is our menu please select from the options below:");
            System.out.println("1. Ice cream");
            System.out.println("2. Sundae");
            System.out.println("3. Milkshakes");
            System.out.println("Select the number of what you would like to order: ");
            int selectOrder = input.nextInt();
            input.nextLine(); // Consume newline left-over

            System.out.println("Small: $2.99");
            System.out.println("Medium: $3.99");
            System.out.println("Large: $5.99");
            System.out.println("Please keep in mind additional toppings .25 cents each.");
            System.out.println("Please select the size you would like: ");
            String selecSize = input.nextLine().toLowerCase();

            // Prices based on size selected
            switch (selecSize) {
                case "small":
                    totalCost += 2.99;
                    break;
                case "medium":
                    totalCost += 3.99;
                    break;
                case "large":
                    totalCost += 5.99;
                    break;
                default:
                    System.out.println("Invalid size selected.");
                    continue;
            }


            String selectedFlavor = "";
            if (selectOrder == 2) { // Sundae option
                SundaeOrder sundaeOrder = new SundaeOrder();
                selectedFlavor = sundaeOrder.orderSundae();
                if (selectedFlavor == null) {
                    System.out.println("No valid sundae option selected, exiting.");
                    continue;
                }
                if (selectOrder == 3) { // Milkshake option
                    milkshakeOrder.orderMilkshake();
                }
            } else {

                // Handle other options: ice cream or milkshakes
                System.out.println("Our shop is best known for our " + flavor1.getIceCreamFlavors());
                System.out.println("But you can choose from the following flavors:");
                System.out.println("Chocolate \n" +
                        "Strawberry \n" +
                        "Cookie dough\n" +
                        "Cookies and Cream\n" +
                        "Cotton Candy\n");
                System.out.print("Which flavor would you like?: ");
                selectedFlavor = input.nextLine().toLowerCase(); // Convert input to lowercase

                if (!isValidFlavor(selectedFlavor)) {
                    System.out.println("Sorry, that's not served at our shop :/");
                    continue;
                }

            }


            System.out.println("You chose: " + selectedFlavor);
            System.out.println("You can choose from the following toppings: None, Rainbow sprinkles, Chocolate sprinkles, Chocolate chips, Oreos, M&Ms, Gummy bears, Reese's pieces");
            System.out.print("Which topping(s) would you like? (Separate with commas): ");
            String toppingsInput = input.nextLine();

            if (isValidTopping(toppingsInput)) {
                System.out.println("You selected: " + toppingsInput);
                if (!toppingsInput.equalsIgnoreCase("None")) {
                    String[] toppings = toppingsInput.split(",");
                    totalCost += toppings.length * 0.25; // Add topping costs
                }
            } else {
                System.out.println("Invalid topping selection. No toppings added.");
            }

            System.out.print("Would you like to order anything else? (Yes/No): ");
            String response = input.nextLine().toLowerCase();
            continueOrdering = response.equals("yes");
        }

        System.out.println("Your total is: $" + String.format("%.2f", totalCost));
        input.close(); // Close the main scanner
    }

    private static boolean isValidFlavor(String flavor) {
        return flavor.equals("vanilla") || flavor.equals("chocolate") ||
                flavor.equals("strawberry") || flavor.equals("cookie dough") ||
                flavor.equals("cookies and cream") || flavor.equals("cotton candy");
    }

    private static boolean isValidTopping(String toppingInput) {
        String[] toppings = toppingInput.split(",");
        for (String topping : toppings) {
            if (!topping.trim().equalsIgnoreCase("None") &&
                    !topping.trim().equalsIgnoreCase("Rainbow sprinkles") &&
                    !topping.trim().equalsIgnoreCase("Chocolate sprinkles") &&
                    !topping.trim().equalsIgnoreCase("Chocolate chips") &&
                    !topping.trim().equalsIgnoreCase("Oreos") &&
                    !topping.trim().equalsIgnoreCase("M&Ms") &&
                    !topping.trim().equalsIgnoreCase("Gummy bears") &&
                    !topping.trim().equalsIgnoreCase("Reese's pieces")) {
                return false;
            }
        }
        return true;
    }
}

