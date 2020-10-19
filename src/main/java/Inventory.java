import java.math.BigDecimal;
import java.util.Scanner;

public class Inventory {
    SqlManager manager = new SqlManager();

    private BigDecimal price;

    //prompts user for new item specs.  Only a manager option
    //should add to database/file
    protected void addItem() {
        Item item = new Item();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter item name.");
        item.setName(keyboard.nextLine());

        System.out.println("Please enter the item type.");
        item.setItem_type(keyboard.nextLine());

        System.out.println("Please enter the price per unit.");
        setPrice(keyboard.nextBigDecimal());
        item.setPricePerUnit(getPrice());

        System.out.println("Please enter the quantity.");
        item.setQuantity(keyboard.nextInt());

        System.out.println("Thank you, your item has been added.");

        manager.add(item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

        keyboard.close();
    }

    //promts user for item id to delete. deletes item from inventory Only a manager option
    //should remove from database
    protected void deleteItem() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What item are you removing ? Please type the item id number.");
        int itemId = keyboard.nextInt();

        System.out.println("Thank you, your item has now been deleted.");
        manager.delete(itemId);

        keyboard.close();
    }


    protected void printItems() {
        manager.selectAll();

    }

    //ask user if they want to change any aspect of an item only a manager option
    protected void updateItem() {
        Item item = new Item();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the id of the item you wish to select.");
        item.setIdNumber(keyboard.nextInt());

        System.out.println("Enter new name or current name if no change.");
        item.setName(keyboard.next());

        System.out.println("Enter new price per unit or current price if no change.");
        item.setPricePerUnit(keyboard.nextBigDecimal());

        System.out.println("Enter new item type or current if no change.");
        item.setItem_type(keyboard.next());

        System.out.println("Enter new quantity or current if no change.");
        item.setQuantity(keyboard.nextInt());

        //String item_name, int item_Id, BigDecimal price_per_unit, String item_type, int quantity

        manager.update(item.getIdNumber(), item.getName(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

        keyboard.close();

    }


    //getters and setters

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
