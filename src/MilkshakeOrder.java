import java.util.Scanner;

public class MilkshakeOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Our shop is known for our Strawberry Milkshakes!");
        System.out.println("Pick your flavor...");
        System.out.println("1.) Chocolate");
        System.out.println("2.) Vanilla");
        System.out.println("3.) Strawberry");
        System.out.println("4.) Cookies and Cream");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        String flavor;
        switch (choice) {
            case 1:
                flavor = "Chocolate";
                System.out.println("You chose Chocolate.");
                break;
            case 2:
                flavor = "Vanilla";
                System.out.println("You chose Vanilla.");
                break;
            case 3:
                flavor = "Strawberry";
                System.out.println("You chose Strawberry.");
                break;
            case 4:
                flavor = "Cookies and Cream";
                System.out.println("You chose Cookies and Cream.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                return;
        }


        System.out.print("Do you want whipped cream? (Yes or No): ");
        boolean whippedCream = scanner.next().equalsIgnoreCase("Yes");


        System.out.print("Do you want cherry? (Yes or No): ");
        boolean cherry = scanner.next().equalsIgnoreCase("Yes");


        System.out.println("Your order summary:");
        System.out.println("Flavor: " + flavor + " Milkshake");
        System.out.println("Whipped Cream: " + (whippedCream ? "Yes" : "No"));
        System.out.println("Cherry: " + (cherry ? "Yes" : "No"));

        scanner.close();
    }
}
