import java.util.Scanner;
public abstract class BaseOrder {
    protected Scanner scanner;
    protected double basePrice;

    public BaseOrder(Scanner scanner, double basePrice) {
        this.scanner = scanner;
        this.basePrice = basePrice;
    }

    public abstract double placeOrder();  // Ensure this is correctly declared

    public double getBasePrice() {
        return basePrice;
    }

    public static void incrementOrderCount() {
        // Assuming there's a static counter here, it needs to be correctly implemented
    }

    public static int getOrderCount() {
        // Return the static order count; ensure it's initialized and incremented correctly
        return 0; // Placeholder, should be a static counter variable
    }
}
