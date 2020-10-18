import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    SqlManager manager = new SqlManager();

    private final List<Integer> itemIdNumbers = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
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
        items.add(item);
        itemIdNumbers.add(item.getIdNumber());

        //need to create loop where whenever a new item is created it sets it number in the list to its id number.
        for (int i = 0; i < 0; i++) {
            item.setIdNumber(i);
        }
        manager.add(item.getName(), item.getIdNumber(), item.getPricePerUnit(), item.getItem_type(), item.getQuantity());

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

    //grab item user is asking for by prompting for id and checks if id is correct
    //returns an item
    protected Item selectItem() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the id of the item you wish to select.");
        int itemId = keyboard.nextInt();

        if (itemIdNumbers.contains(itemId)) {
            return items.get(itemId);
        } else {
            System.out.println("Invalid item id number.");
        }
        keyboard.close();
        return null;
    }

    //ask user if they want to change any aspect of an item only a manager option
    protected void updateItem() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter new name or current name if no change.");
        selectItem().setName(keyboard.nextLine());

        System.out.println("Enter new price per unit or current price if no change.");
        selectItem().setPricePerUnit(keyboard.nextBigDecimal());

        System.out.println("Enter new item type or current if no change.");
        selectItem().setItem_type(keyboard.nextLine());

        System.out.println("Enter new quantity or current if no change.");
        selectItem().setQuantity(keyboard.nextInt());

        //String item_name, int item_Id, BigDecimal price_per_unit, String item_type, int quantity
        String name = selectItem().getName();
        BigDecimal price = selectItem().getPricePerUnit();
        String type = selectItem().getItem_type();
        int quantity = selectItem().getQuantity();
        manager.update(name, price, type, quantity);

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
