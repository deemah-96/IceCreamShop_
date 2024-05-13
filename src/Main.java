import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Flavors flavorOrder = new Flavors(input); // Handles all ice cream-related orders
        SundaeOrder sundaeOrder = new SundaeOrder(input); // Handles all sundae-related orders
        MilkshakeOrder milkshakeOrder = new MilkshakeOrder(input); // Handles all milkshake-related orders

        boolean continueOrdering = true;
        double totalCost = 0.0;

        while (continueOrdering) {
            System.out.println("Welcome to IS147 Ice Cream Shop");
            System.out.println("Below is our menu, please select from the options below:");
            System.out.println("1. Ice cream");
            System.out.println("2. Sundae");
            System.out.println("3. Milkshakes");
            int selectOrder = 0;
            boolean validSelection = false;
            while (!validSelection) {
                System.out.println("Select the number of what you would like to order: ");
                if (input.hasNext()) {
                    selectOrder = input.nextInt();
                    input.nextLine();
                    if (selectOrder >= 1 && selectOrder <= 3) {
                        validSelection = true;
                    } else {
                        System.out.println("Invalid selection. Please select a valid option.");
                    }
                } else {
                    System.out.println("Invalid selection. Please select a valid option.");
                    input.next();
                }
            }

            double sizeCost = askForSizeAndCalculateCost(input);
            if (sizeCost == 0) {  // If invalid size or cancel, skip this order.
                System.out.println("Invalid size selected, please try again.");
                continue;  // Continues to the next iteation of the while loop.
            }

            switch (selectOrder) {
                case 1:
                    totalCost += flavorOrder.placeOrder();

                    break;
                case 2:
                    totalCost += sundaeOrder.orderSundae();
                    break;
                case 3:
                    totalCost += milkshakeOrder.orderMilkshake();
                    break;
                default:
                    System.out.println("Invalid selection. Please select a valid option.");
                    continue; // Skip to the next iteration if invalid choice
            }

            System.out.print("Would you like to order anything else? (Yes/No): ");
            String response = input.nextLine().toLowerCase();
            continueOrdering = response.equals("yes");
        }

        System.out.println("Your total is: $" + String.format("%.2f", totalCost));
        input.close();  // Close the main scanner
    }

    private static double askForSizeAndCalculateCost(Scanner input) {
        System.out.println("Please select the size you would like:");
        System.out.println("Small: $2.99");
        System.out.println("Medium: $3.99");
        System.out.println("Large: $5.99");
        System.out.println("Please keep in mind that toppings are an additional .25 cents each.");
       String sizeChoice;
       double cost = 0;
       boolean validSizeSelected = false;
       while (!validSizeSelected) {
           System.out.print("Enter your choice : ");
           sizeChoice = input.nextLine().toLowerCase();

        switch (sizeChoice) {
            case "small":
                cost = 2.99;
                validSizeSelected = true;
                break;
            case "medium":
                cost = 3.99;
                validSizeSelected = true;
                break;
            case "large":
                cost = 5.99;
                validSizeSelected = true;
                break;
            default:
                System.out.println("Invalid size selected. Please select again.");
                break;
        }
    }
    return cost;
}
}