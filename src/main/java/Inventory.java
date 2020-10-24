import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Inventory {
    SqlManager manager = new SqlManager();

    private BigDecimal price;

    //prompts user for new item specs.  Only a manager option
    //should add to database/file
    protected void addItem() throws IOException {
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter item name.");
        item.setName(scanner.nextLine());

        System.out.println("Please enter the item type.");
        item.setItem_type(scanner.nextLine());

        System.out.println("Please enter the price per unit.");
        setPrice(scanner.nextBigDecimal());
        item.setPricePerUnit(getPrice());

        System.out.println("Please enter the quantity.");
        item.setQuantity(scanner.nextInt());

        System.out.println("Thank you, your item has been added.");

        manager.add(item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

    }

    //prompts user for item id to delete. deletes item from inventory Only a manager option
    //should remove from database
    protected void deleteItem() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What item are you removing ? Please type the item id number.");
        int itemId = (scanner.nextInt());

        System.out.println("Thank you, your item has now been deleted.");
        manager.delete(itemId);

    }

    //prints entire database
    protected void printItems() {
        manager.selectAll();
    }

    //ask user if they want to change any aspect of an item only a manager option
    protected void updateItem() throws IOException {
        Item item = new Item();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the id of the item you wish to select.");
        item.setIdNumber(scanner.nextInt());

        System.out.println("Enter new name or current name if no change.");
        item.setName(scanner.nextLine());

        System.out.println("Enter new price per unit or current price if no change.");
        item.setPricePerUnit(scanner.nextBigDecimal());

        System.out.println("Enter new item type or current if no change.");
        item.setItem_type(scanner.nextLine());

        System.out.println("Enter new quantity or current if no change.");
        item.setQuantity(scanner.nextInt());

        //String item_name, int item_Id, BigDecimal price_per_unit, String item_type, int quantity

        manager.update(item.getIdNumber(), item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

    }


    //getters and setters

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //input validation
    private Integer validateInteger() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = scanner.nextInt();

            scanner.close();
            System.in.close();

            return number;

        } while (number < 0);


    }

    private String validateString() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String string;
        do {
            while (!scanner.hasNextLine()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid input.\n", input);
            }
            string = scanner.nextLine();

            scanner.close();
            System.in.close();

            return string;

        } while (!string.isEmpty());

    }

    private BigDecimal validateBigDecimal() throws IOException {
        Scanner scanner = new Scanner(System.in);

        BigDecimal number;
        do {

            while (!scanner.hasNextBigDecimal()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid price.\n", input);
            }
            number = scanner.nextBigDecimal();

            scanner.close();
            System.in.close();

            return number;

        } while (number.compareTo(BigDecimal.ZERO) > 0);
    }
}
