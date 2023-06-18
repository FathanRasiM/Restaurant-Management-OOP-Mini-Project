import java.util.*;

class MenuItem {
    private String name;
    private String code;
    private double price;

    public MenuItem(String name, String code, double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }
}

class RestaurantMenu {
    private List<MenuItem> foodItems;
    private List<MenuItem> drinkItems;

    public RestaurantMenu() {
        foodItems = new ArrayList<>();
        drinkItems = new ArrayList<>();
    }

    public void addFoodItem(String name, String code, double price) {
        MenuItem item = new MenuItem(name, code, price);
        foodItems.add(item);
    }

    public void addDrinkItem(String name, String code, double price) {
        MenuItem item = new MenuItem(name, code, price);
        drinkItems.add(item);
    }

    public List<MenuItem> getFoodItems() {
        return foodItems;
    }

    public List<MenuItem> getDrinkItems() {
        return drinkItems;
    }

    public void displayMenu() {
        System.out.println("Menu\n_______________________________________");
        System.out.println("Food:\t\t\tCode:\t\tPrice:");

        for (MenuItem item : foodItems) {
            System.out.println(item.getName() + "\t\t" + item.getCode() + "\t\t" + item.getPrice() + " RM");
        }

        System.out.println("\nDrink:\t\t\tCode:\t\tPrice:");

        for (MenuItem item : drinkItems) {
            System.out.println(item.getName() + "\t\t" + item.getCode() + "\t\t" + item.getPrice() + " RM");
        }

        System.out.println("_______________________________________");
    }
}

class OnlineOrderSystem {
    private List<MenuItem> orderItems;
    private double totalPrice;

    public OnlineOrderSystem() {
        orderItems = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addItem(MenuItem item) {
        orderItems.add(item);
        totalPrice += item.getPrice();
    }

    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

public class RestaurantOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantMenu menu = new RestaurantMenu();
        OnlineOrderSystem orderSystem = new OnlineOrderSystem();

        // Add menu items
        menu.addFoodItem("Nasi Lemak", "F1", 5);
        menu.addFoodItem("Mee goreng", "F2", 6);
        menu.addFoodItem("Kwetiau Hailam", "F3", 7);
        menu.addDrinkItem("Milo", "D1", 2);
        menu.addDrinkItem("Tea", "D2", 1);
        menu.addDrinkItem("Juice", "D3", 3);

        // Display menu
        menu.displayMenu();

        // Input order details
        System.out.println("(Input your order details here)");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Table number: ");
        int tableNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Input order items
        System.out.println("Order " + orderSystem.getOrderItems().size() + ":");
        System.out.print("Enter item code: ");
        String itemCode = scanner.nextLine();
        MenuItem selectedItem = findMenuItem(menu, itemCode);

        if (selectedItem != null) {
            orderSystem.addItem(selectedItem);
            System.out.println("Item added to order.");
        } else {
            System.out.println("Invalid item code. Item not added to order.");
        }

        // Display total price of the order
        System.out.println("\nTotal Price of Order = " + orderSystem.getTotalPrice() + " RM");
    }

    private static MenuItem findMenuItem(RestaurantMenu menu, String itemCode) {
        for (MenuItem item : menu.getFoodItems()) {
            if (item.getCode().equals(itemCode)) {
                return item;
            }
        }

        for (MenuItem item : menu.getDrinkItems()) {
            if (item.getCode().equals(itemCode)) {
                return item;
            }
        }

        return null;
    }
}





