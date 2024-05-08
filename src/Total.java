public class Total {

if (!option.equals("Cup") && !option.equals("Cone")) {
        System.out.println("Sorry, that's not served at our shop :/");
        } else {
        double basePrice = 0.0;

        if (option.equalsIgnoreCase("Cup")) {
        basePrice = 3.99;
        } else if (option.equalsIgnoreCase("Cone")) {
        basePrice = 4.99;
        } else{
        basePrice=5.99;{
        }
        }
        double toppingPrice = 0.0;
        if (!toppingsInput.equalsIgnoreCase("None")) {
        String[] toppings = toppingsInput.split(",");
        toppingPrice = toppings.length * 0.25;
        }

        double totalPrice = basePrice + toppingPrice;
        System.out.println("Your total is: $" + String.format("%.2f", totalPrice));
        }
        }
        }