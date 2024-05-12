import java.util.Scanner;

public class OrderProcess {
        private Scanner scanner;

        public OrderProcess() {
                this.scanner = new Scanner(System.in);
        }

        public void closeScanner() {
                scanner.close();
        }

        public void processOrder() {
                System.out.println("Would you like a Cup or a Cone?");
                String option = scanner.nextLine();

                double basePrice = 0.0;
                if (option.equalsIgnoreCase("Cup")) {
                        basePrice = 3.99;
                } else if (option.equalsIgnoreCase("Cone")) {
                        basePrice = 4.99;
                } else {
                        System.out.println("Sorry, that's not served at our shop :/");
                        return;
                }

                System.out.println("Please select toppings: None, Rainbow sprinkles, Chocolate sprinkles, Chocolate chips, Oreos, M&Ms, Gummy bears, Reese's pieces");
                String toppingsInput = scanner.nextLine();
                double toppingPrice = 0.0;

                if (!toppingsInput.equalsIgnoreCase("None")) {
                        String[] toppings = toppingsInput.split(",");
                        toppingPrice = toppings.length * 0.25;
                }

                double totalPrice = basePrice + toppingPrice;
                System.out.println("Your total is: $" + String.format("%.2f", totalPrice));
        }
}