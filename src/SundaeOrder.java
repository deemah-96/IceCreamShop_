import java.util.Scanner;

public class SundaeOrder {
    private Scanner scanner;

   public SundaeOrder(Scanner scanner){
       this.scanner = scanner;
   }

    public double orderSundae() {
        System.out.println("Our shop is known for our Hot fudge sundaes!");
        System.out.println("Pick your flavor...");
        System.out.println("1.) Banana Split");
        System.out.println("2.) Strawberry Shortcake");
        System.out.println("3.) Pazookie");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        double cost = 0.0;
        switch (choice) {
            case 1:
                System.out.println("Banana Split selected.");
                break;
            case 2:
                System.out.println("Strawberry Shortcake selected.");
                break;
            case 3:
                System.out.println("Pazookie selected.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                return 0;
        }
// hello
        return cost;
    }

    public void closeScanner() {
        scanner.close();
    }
}
