import java.util.Scanner;

public class Inventory{
    SqlManager manager = new SqlManager();

    private int internalPrice;

    //prompts user for new item specs.  Only a manager option
    //should add to database/file
    protected void addItem() {
        Item item = new Item();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter item name.");
        item.setName(keyboard.nextLine());

        System.out.println("Please enter the item type.");
        item.setItem_type(keyboard.nextLine());

        System.out.println("Please enter item id number.");
        item.setIdNumber(keyboard.nextInt());

        System.out.println("Please enter the price per unit.");
        setPrice(keyboard.nextDouble());
        item.setPricePerUnit(getInternalPrice());

        System.out.println("Please enter the quantity.");
        item.setQuantity(keyboard.nextInt());

        System.out.println("Thank you, your item has been added.");
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

    //getters and setters
    public int getInternalPrice() {
        return internalPrice;
    }

    public double getPrice() {
        return internalPrice / 100.0;
    }

    public void setPrice(double price) {
        this.internalPrice = (int) (price * 100);
    }

}
