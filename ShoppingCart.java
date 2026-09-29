import java.util.ArrayList;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(
            "Name: " + name +
            ", Price: " + price +
            ", Quantity: " + quantity
        );
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        ArrayList<Item> cart = new ArrayList<>();

        // 1. Add items
        cart.add(new Item("Laptop", 45000, 1));
        cart.add(new Item("Mouse", 800, 2));
        cart.add(new Item("Keyboard", 1500, 1));
        cart.add(new Item("Headphones", 2500, 1));

        System.out.println("----- Items Added -----");

        // 2. Remove item
        String removeItem = "Keyboard";

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equals(removeItem)) {
                cart.remove(i);
                System.out.println(removeItem + " removed.");
                break;
            }
        }

        // 3. Update quantity
        String updateItem = "Mouse";
        int newQuantity = 3;

        for (Item item : cart) {
            if (item.name.equals(updateItem)) {
                item.quantity = newQuantity;
                System.out.println(updateItem + " quantity updated.");
                break;
            }
        }

        // 4. Search item
        String searchItem = "Laptop";
        boolean found = false;

        System.out.println("\n----- Search Item -----");

        for (Item item : cart) {
            if (item.name.equals(searchItem)) {
                System.out.println("Item found:");
                item.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }

        // 5. Display cart
        System.out.println("\n----- Shopping Cart -----");

        for (Item item : cart) {
            item.display();
        }

        // 6. Calculate total bill
        double total = 0;

        for (Item item : cart) {
            total = total + (item.price * item.quantity);
        }

        System.out.println("\n----- Total Bill -----");
        System.out.println("Total Bill: ₹" + total);

        // Challenge
        if (total > 5000) {
            System.out.println(
                "Congratulations! You are officially poor."
            );
        }
    }
}