import java.util.ArrayList;
import java.util.Scanner;

public class DataManagementSystem {
    // Table 1 columns
    private static ArrayList<Integer> tableNumbers = new ArrayList<>();
    private static ArrayList<String> staffNames = new ArrayList<>();

    // Table 2 columns
    private static ArrayList<Integer> orderNumbers = new ArrayList<>();
    private static ArrayList<Integer> tableNumbers2 = new ArrayList<>();
    private static ArrayList<Integer> itemNumbers = new ArrayList<>();
    private static ArrayList<String> itemNames = new ArrayList<>();
    private static ArrayList<Integer> quantities = new ArrayList<>();
    private static ArrayList<Double> prices = new ArrayList<>();
    private static ArrayList<String> comments = new ArrayList<>();

    // Table 3 columns - Invoice
    private static ArrayList<Integer> invoiceOrderNumbers = new ArrayList<>();
    private static ArrayList<String> invoiceDates = new ArrayList<>();
    private static ArrayList<String> invoiceStaffNames = new ArrayList<>();
    private static ArrayList<Integer> invoiceTableNumbers = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> invoiceItemNumbers = new ArrayList<>();
    private static ArrayList<ArrayList<String>> invoiceItemNames = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> invoiceQuantities = new ArrayList<>();
    private static ArrayList<ArrayList<Double>> invoicePrices = new ArrayList<>();
    private static double vatRate = 0.2; // 20% VAT rate

    public static void main(String[] args) {
        initializeData(); // Initialize data with sample entries
        displayMenu();
    }

    private static void initializeData() {
        // Populate data structures with sample entries for Table 1
        tableNumbers.add(0);
        staffNames.add("Kiran");
        tableNumbers.add(1);
        staffNames.add("Sam");
        tableNumbers.add(2);
        staffNames.add("Jill");
        tableNumbers.add(3);
        staffNames.add("Jill");
        tableNumbers.add(4);
        staffNames.add("Sam");
        tableNumbers.add(5);
        staffNames.add("Jill");
        tableNumbers.add(6);
        staffNames.add("Sam");
        tableNumbers.add(7);
        staffNames.add("Sam");
        tableNumbers.add(8);
        staffNames.add("Jill");

        // Populate data structures with sample entries for Table 2
        orderNumbers.add(101);
        tableNumbers2.add(1);
        itemNumbers.add(95);
        itemNames.add("Pop drink");
        quantities.add(2);
        prices.add(2.35);
        comments.add("Pepsi, No ice");

        orderNumbers.add(102);
        tableNumbers2.add(2);
        itemNumbers.add(21);
        itemNames.add("Jacket potato");
        quantities.add(1);
        prices.add(3.20);
        comments.add("with beans");

        orderNumbers.add(103);
        tableNumbers2.add(0);
        itemNumbers.add(55);
        itemNames.add("Lasagne");
        quantities.add(1);
        prices.add(6.95);
        comments.add("with cheese");
        
        orderNumbers.add(103);
        tableNumbers2.add(0);
        itemNumbers.add(61);
        itemNames.add("Mac & cheese");
        quantities.add(1);
        prices.add(2.20);
        comments.add(" ");
        
        orderNumbers.add(103);
        tableNumbers2.add(0);
        itemNumbers.add(81);
        itemNames.add("Choc brownie");
        quantities.add(1);
        prices.add(2.55);
        comments.add(" ");
        
        orderNumbers.add(104);
        tableNumbers2.add(3);
        itemNumbers.add(91);
        itemNames.add("Tea (pot)");
        quantities.add(1);
        prices.add(2.99);
        comments.add("2 empty cups");
        
        orderNumbers.add(105);
        tableNumbers2.add(4);
        itemNumbers.add(92);
        itemNames.add("Cofee");
        quantities.add(3);
        prices.add(2.50);
        comments.add("White, no sugar");
        
        orderNumbers.add(101);
        tableNumbers2.add(1);
        itemNumbers.add(33);
        itemNames.add("Bacon Egg Cheese");
        quantities.add(1);
        prices.add(3.75);
        comments.add(" ");
        
        orderNumbers.add(101);
        tableNumbers2.add(1);
        itemNumbers.add(49);
        itemNames.add("Veg burger");
        quantities.add(1);
        prices.add(4.95);
        comments.add(" ");
        
        orderNumbers.add(102);
        tableNumbers2.add(2);
        itemNumbers.add(95);
        itemNames.add("Pop drink");
        quantities.add(1);
        prices.add(2.35);
        comments.add("Lemonade");
        
        orderNumbers.add(104);
        tableNumbers2.add(3);
        itemNumbers.add(51);
        itemNames.add("Steak Ale pie");
        quantities.add(1);
        prices.add(6.95);
        comments.add(" ");
        
        orderNumbers.add(105);
        tableNumbers2.add(4);
        itemNumbers.add(45);
        itemNames.add("Egg Mayo baguette");
        quantities.add(1);
        prices.add(2.95);
        comments.add(" ");

        ArrayList<Integer> invoice1ItemNumbers = new ArrayList<>();
        ArrayList<String> invoice1ItemNames = new ArrayList<>();
        ArrayList<Integer> invoice1Quantities = new ArrayList<>();
        ArrayList<Double> invoice1Prices = new ArrayList<>();
        
        invoice1ItemNumbers.add(95);
        invoice1ItemNumbers.add(33);
        invoice1ItemNumbers.add(49);
        
        invoice1ItemNames.add("Pop drink Pepsi (no ice)");
        invoice1ItemNames.add("Bacon Egg Cheese sandwich");
        invoice1ItemNames.add("Veg Burger");
        
        invoice1Quantities.add(2);
        invoice1Quantities.add(1);
        invoice1Quantities.add(1);
        
        invoice1Prices.add(2.35);
        invoice1Prices.add(3.75);
        invoice1Prices.add(4.95);
        
        invoiceOrderNumbers.add(101);
        invoiceDates.add("1-Oct-2023");
        invoiceStaffNames.add("Jill");
        invoiceTableNumbers.add(2);
        invoiceItemNumbers.add(invoice1ItemNumbers);
        invoiceItemNames.add(invoice1ItemNames);
        invoiceQuantities.add(invoice1Quantities);
        invoicePrices.add(invoice1Prices);
    }

    private static void displayMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add Entry");
                System.out.println("2. Update Entry");
                System.out.println("3. Delete Entry");
                System.out.println("4. View Entries");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the rest of the line

                switch (choice) {
                    case 1:
                        addEntry(scanner);
                        break;
                    case 2:
                        updateEntry(scanner);
                        break;
                    case 3:
                        deleteEntry(scanner);
                        break;
                    case 4:
                        viewEntries();
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void addEntry(Scanner scanner) {
        // Add entries for Table 1
        System.out.print("Enter the new table number for Table 1: ");
        int tableNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new staff name for Table 1: ");
        String staffName = scanner.nextLine();
        tableNumbers.add(tableNum);
        staffNames.add(staffName);

        // Add entries for Table 2
        System.out.print("Enter the new order number for Table 2: ");
        int orderNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new table number for Table 2: ");
        int tableNum2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new item number for Table 2: ");
        int itemNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new item name for Table 2: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter the new quantity for Table 2: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter the new price for Table 2: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the new comment for Table 2: ");
        String comment = scanner.nextLine();

        orderNumbers.add(orderNum);
        tableNumbers2.add(tableNum2);
        itemNumbers.add(itemNum);
        itemNames.add(itemName);
        quantities.add(quantity);
        prices.add(price);
        comments.add(comment);

        System.out.println("Entries added successfully!");
    }

    private static void updateEntry(Scanner scanner) {
        System.out.println("Which table would you like to update? (1 for Table 1, 2 for Table 2)");
    int tableChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    int index;
    switch (tableChoice) {
        case 1:
            System.out.println("Enter the index of the entry to update in Table 1:");
            index = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (index >= 0 && index < tableNumbers.size()) {
                System.out.println("Enter new table number:");
                tableNumbers.set(index, scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new staff name:");
                staffNames.set(index, scanner.nextLine());
                System.out.println("Table 1 entry updated successfully!");
            } else {
                System.out.println("Invalid index.");
            }
            break;
        case 2:
            System.out.println("Enter the index of the entry to update in Table 2:");
            index = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (index >= 0 && index < orderNumbers.size()) {
                System.out.println("Enter new order number:");
                orderNumbers.set(index, scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new table number:");
                tableNumbers2.set(index, scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new item number:");
                itemNumbers.set(index, scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new item name:");
                itemNames.set(index, scanner.nextLine());
                System.out.println("Enter new quantity:");
                quantities.set(index, scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new price:");
                prices.set(index, scanner.nextDouble());
                scanner.nextLine(); // Consume newline
                System.out.println("Enter new comment:");
                comments.set(index, scanner.nextLine());
                System.out.println("Table 2 entry updated successfully!");
            } else {
                System.out.println("Invalid index.");
            }
            break;
        default:
            System.out.println("Invalid table choice.");
            break;
        }
    }

    private static void deleteEntry(Scanner scanner) {
        System.out.println("Which table would you like to delete from? (1 for Table 1, 2 for Table 2)");
    int tableChoice = scanner.nextInt();
    scanner.nextLine(); // Consume newline left-over

    int index;
    switch (tableChoice) {
        case 1:
            System.out.println("Enter the index of the entry to delete in Table 1:");
            index = scanner.nextInt();
            if (index >= 0 && index < tableNumbers.size()) {
                tableNumbers.remove(index);
                staffNames.remove(index);
                System.out.println("Table 1 entry deleted successfully!");
            } else {
                System.out.println("Invalid index.");
            }
            break;
        case 2:
            System.out.println("Enter the index of the entry to delete in Table 2:");
            index = scanner.nextInt();
            if (index >= 0 && index < orderNumbers.size()) {
                // Since all lists are parallel, we need to remove the element from each.
                orderNumbers.remove(index);
                tableNumbers2.remove(index);
                itemNumbers.remove(index);
                itemNames.remove(index);
                quantities.remove(index);
                prices.remove(index);
                comments.remove(index);
                System.out.println("Table 2 entry deleted successfully!");
            } else {
                System.out.println("Invalid index.");
            }
            break;
        default:
            System.out.println("Invalid table choice.");
            break;
        }
    }

    private static void viewEntries() {
        // View entries for Table 1 and Table 2
        // Display entries for Table 1
        System.out.println("Table 1. Table allocation.");
        System.out.printf("%-7s %-5s%n", "Table#", "Staff");
        for (int i = 0; i < tableNumbers.size(); i++) {
            System.out.printf("%-7d %-5s%n", tableNumbers.get(i), staffNames.get(i));
        }

        // Display entries for Table 2
        System.out.println("\nTable 2. Typical items ordered.");
        System.out.printf("%-8s %-7s %-6s %-18s %-4s %-6s %-15s%n", "Order#", "Table#", "Item#", "Name", "Qty", "Price", "Comment");
        for (int i = 0; i < orderNumbers.size(); i++) {
            System.out.printf("%-8d %-7d %-6d %-18s %-4d $%-5.2f %-15s%n", orderNumbers.get(i), tableNumbers2.get(i),
                    itemNumbers.get(i), itemNames.get(i), quantities.get(i), prices.get(i), comments.get(i));
        }

        System.out.println("\nTable 3. Sample invoice for Order# " + invoiceOrderNumbers.get(0));
        System.out.printf("Order#: %d\tDate: %s\tTable#: %d\tStaff: %s%n", invoiceOrderNumbers.get(0), invoiceDates.get(0), invoiceTableNumbers.get(0), invoiceStaffNames.get(0));
        System.out.println("Item#\tName\t\t\tQty\tPrice\tSub-total");
        double total = 0.0;
        for (int i = 0; i < invoiceItemNumbers.get(0).size(); i++) {
            double subTotal = invoiceQuantities.get(0).get(i) * invoicePrices.get(0).get(i);
            total += subTotal;
            System.out.printf("%d\t%s\t%d\t%.2f\t%.2f%n", invoiceItemNumbers.get(0).get(i), invoiceItemNames.get(0).get(i), invoiceQuantities.get(0).get(i), invoicePrices.get(0).get(i), subTotal);
        }
        double vatAmount = total * vatRate / (1 + vatRate);
        System.out.printf("Total: %.2f%nVAT (20%%): %.2f%nNet amount: %.2f%n", total, vatAmount, total - vatAmount);
    }
    
}
