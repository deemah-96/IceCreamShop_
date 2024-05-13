import java.util.Scanner;

public class MilkshakeOrder {
    private Scanner scanner; // Declare the scanner object

    // Constructor accepts an existing Scanner object
    public MilkshakeOrder(Scanner scanner) {
        this.scanner = scanner;
    }

    public double orderMilkshake() {
        System.out.println("Our shop is known for our Strawberry Milkshakes!");
        System.out.println("Pick your flavor...");
        System.out.println("1.) Chocolate");
        System.out.println("2.) Vanilla");
        System.out.println("3.) Strawberry");
        System.out.println("4.) Cookies and Cream");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        double price = 4.99;
        String flavor;
        switch (choice) {
            case 1:
                flavor = "Chocolate";
                break;
            case 2:
                flavor = "Vanilla";
                break;
            case 3:
                flavor = "Strawberry";
                break;
            case 4:
                flavor = "Cookies and Cream";
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                return 0;
        }

        System.out.print("Do you want whipped cream? (Yes or No): ");
        boolean whippedCream = scanner.next().equalsIgnoreCase("Yes");
            if (whippedCream) {
                price += 0.50;
            }
        scanner.nextLine(); // Consume the newline

        System.out.print("Do you want a cherry on top? (Yes or No): ");
        boolean cherry = scanner.next().equalsIgnoreCase("Yes");
            if (cherry){
                price += 0.25;
            }
        scanner.nextLine(); // Consume the newline

        System.out.println("Your order summary:");
        System.out.println("Flavor: " + flavor + " Milkshake");
        System.out.println("Whipped Cream: " + (whippedCream ? "Yes" : "No"));
        System.out.println("Cherry: " + (cherry ? "Yes" : "No"));
            return price;
    }
}

