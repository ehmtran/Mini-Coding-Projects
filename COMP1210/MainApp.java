import java.util.ArrayList;

import java.util.Scanner;

/*
Base Class
*/
class User {
    // TODO: declare objects
    protected String name;
    protected int userId;

    // TODO: write constructor
    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    // display info method
    public void displayInfo() {
        System.out.println("User: " + name + ", ID: " + userId);
    }
}

/*
 * Inheritance
 */
class RegularCustomer extends User {
    public RegularCustomer(String name, int userId) {
        super(name, userId);
    }

    @Override
    public void displayInfo() {
        // TODO: Print as Regular Customer
        System.out.println("Regular Customer: " + name + ", ID: " + userId);
    }
}

class PremiumCustomer extends User {
    public PremiumCustomer(String name, int userId) {
        super(name, userId);
    }

    @Override
    public void displayInfo() {
        // TODO: Print as Premium Customer with discount note
        System.out.println("Premium Customer: " + name + ", ID: " + userId);
    }
}

/*
 * Interface
 */
interface Billable {
    double calculateBill();
}

/*
 * Food Order Class
 */
class FoodOrder implements Billable {
    private User customer;
    private String itemName;
    private double price;

    public FoodOrder(User customer, String itemName, double price) {
        this.customer = customer;
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public double calculateBill() {
        // TODO:
        // If customer is PremiumCustomer → apply 10% discount
        if (customer instanceof PremiumCustomer) {
            return price * 0.9;
        }
        // else return full price
        else {
            return price;
        }
    }

    public void displayOrder() {
        // customer.displayInfo();
        // TODO: print item and final bill
        System.out.println("Order placed!");
        System.out.println("Final Bill: $" + calculateBill());
    }
}

/*
 * Main Program
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<FoodOrder> orders = new ArrayList<>();
        int choice;
        // declare variables for input reading
        String name;
        int userId;
        do {
            System.out.println("\n--- Food Ordering System ---");
            System.out.println("1. Add Regular Customer");
            System.out.println("2. Add Premium Customer");
            System.out.println("3. Place Order");
            System.out.println("4. Display All Users");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // TODO:
                    // 1. Read name and ID
                    System.out.print("Enter name: ");
                    name = sc.next();
                    System.out.print("Enter ID: ");
                    userId = sc.nextInt();
                    System.out.println();
                    // 2. Create RegularCustomer object
                    RegularCustomer regularCustomer = new RegularCustomer(name, userId);
                    // 3. Add to users list
                    users.add(regularCustomer);
                    System.out.println("Customer added!");
                    break;
                case 2:
                    // TODO:
                    // 1. Read name and ID
                    System.out.print("Enter name: ");
                    name = sc.next();
                    System.out.print("Enter ID: ");
                    userId = sc.nextInt();
                    System.out.println();
                    // 2. Create PremiumCustomer object
                    PremiumCustomer premiumCustomer = new PremiumCustomer(name, userId);
                    // 3. Add to users list
                    users.add(premiumCustomer);
                    System.out.println("Premium customer added!");
                    break;
                case 3:
                    // TODO:
                    // 1. Check if users list is empty
                    if (users.isEmpty()) {
                        System.out.println("No customers available. Please add a customer first.");
                    } else {
                        // 2. Get user index
                        System.out.print("Enter customer index: ");
                        int userIndex = sc.nextInt();
                        // 3. Read item name and price
                        System.out.print("Enter item: ");
                        String itemName = sc.next();
                        System.out.print("Enter price: ");
                        double price = sc.nextDouble();
                        System.out.println();
                        // 4. Validate price (must be >= 0)
                        if (price < 0) {
                            System.out.println("Invalid price");
                            break;
                        }
                        // 5. Create FoodOrder
                        FoodOrder order = new FoodOrder(users.get(userIndex), itemName, price);
                        // 6. Add to orders list
                        orders.add(order);
                        // 7. Display order
                        order.displayOrder();
                    }
                    break;
                case 4:
                    // TODO:
                    // Loop through users and call displayInfo()
                    System.out.println();
                    for (User user : users) {
                        user.displayInfo();
                    }
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}