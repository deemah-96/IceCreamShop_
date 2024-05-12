import java.util.Scanner;

public class SundaeOrder {
    private Scanner scanner;

    public SundaeOrder() {
        this.scanner = new Scanner(System.in);
    }

    public String orderSundae() {
        System.out.println("Our shop is known for our Hot fudge sundaes!");
        System.out.println("Pick your flavor...");
        System.out.println("1.) Banana Split");
        System.out.println("2.) Strawberry Shortcake");
        System.out.println("3.) Pazookie");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        String flavor = "";
        switch (choice) {
            case 1:
                flavor = "Banana Split";
                break;
            case 2:
                flavor = "Strawberry Shortcake";
                break;
            case 3:
                flavor = "Pazookie";
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                return null; // Return null to indicate an invalid choice.
        }

        return flavor;
    }

    public void closeScanner() {
        scanner.close();
    }
}
