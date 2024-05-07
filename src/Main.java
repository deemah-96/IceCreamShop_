import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Flavors flavor1 = new Flavors();

        System.out.println("Our shop is best known for our " + flavor1.getIceCreamFlavors());
        System.out.println("But you can choose from the following flavors:");
        System.out.println("Chocolate \n" +
                "Strawberry \n" +
                "Cookie dough\n" +
                "Cookies and Cream\n" +
                "Cotton Candy\n");
        System.out.print("Which flavor would you like?: ");
        String selection = input.nextLine().toLowerCase(); // Convert input to lowercase

        System.out.println();

        if (!selection.equals("vanilla") && !selection.equals("chocolate") &&
                !selection.equals("strawberry") && !selection.equals("cookie dough") &&
                !selection.equals("cookies and cream") && !selection.equals("cotton candy")) {
            System.out.println("Sorry, that's not served at our shop :/");
        } else {
            System.out.println("Our shop is best known for our " + selection);
            System.out.println("But you can choose from the following options:");
            System.out.println("Cup \n" +
                    "Cone \n"
            );
            System.out.print("Which option would you like?: ");
            String option = input.nextLine();

            if (!option.equals("Cup") && !option.equals("Cone")) {
                System.out.println("Sorry, that's not served at our shop :/");
            } else {
                System.out.println("You can choose from the following options:");
                System.out.println("None \n" + "Rainbow sprinkles \n" +
                        "Chocolate sprinkles \n" +
                        "Chocolate chips \n" +
                        "Oreos \n" +
                        "M&Ms \n" +
                        "Gummy bears \n" +
                        "Reese's pieces \n"
                );
                System.out.print("Which topping(s) would you like? (Separate with commas): ");
                String toppingsInput = input.nextLine();

                if (toppingsInput.equalsIgnoreCase("None")) {
                    System.out.print("Would you like to order anything else? Yes or No: ");
                    String YesNo = input.nextLine();
                    if (YesNo.equalsIgnoreCase("No")) {
                        System.out.println("Your total is:");
                    } else {
                        // Implement logic for further ordering
                    }
                } else {
                    // Split the input by commas and trim any leading/trailing spaces
                    String[] toppings = toppingsInput.split(",");
                    boolean isValid = true;
                    for (String topping : toppings) {
                        if (!isValidTopping(topping.trim())) { // Trim leading/trailing spaces
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        System.out.print("Would you like to order anything else? Yes or No: ");
                        String YesNo = input.nextLine();
                        if (YesNo.equalsIgnoreCase("No")) {
                            System.out.println("Your total is:");
                        } else {
                            // Implement logic for further ordering
                        }
                    } else {
                        System.out.println("Sorry, one or more of the selected toppings are not served at our shop :/");
                    }
                }
            }
        }
    }

    public static boolean isValidTopping(String topping) {
        return topping.equals("None") || topping.equals("Rainbow sprinkles") || topping.equals("Chocolate sprinkles") ||
                topping.equals("Chocolate chips") || topping.equals("Oreos") ||
                topping.equals("M&Ms") || topping.equals("Gummy bears") ||
                topping.equals("Reese's pieces");
    }
}