import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory{

    //attributes of an inventory
    private int number_Of_Item;
    private List<Item> items;
    List<itemType> types = new ArrayList<>();

    //prompts user for new item specs.  Only a manager option
    //should add to database/file
    protected void addItem() {
        Item item = new Item();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter item name.");
        item.setName(keyboard.nextLine());

        System.out.println("Please enter item id number.");
        item.setIdNumber(keyboard.nextInt());

        System.out.println("Please enter the price per unit.");
        item.setPricePerUnit(keyboard.nextInt());

        System.out.println("Please enter the item type. Acceptable types:" + types);
        item.setItem_type((itemType) keyboard.findAll(String.valueOf(types)));

        System.out.println("Please enter the quantity.");
        item.setQuantity(keyboard.nextInt());

        items.add(item);
        keyboard.close();
    }

    //promts user for item id to delete. deletes item from inventory Only a manager option
    //should remove from database
    protected void deleteItem() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What item are you removing ? Please type the item id number.");
        String itemId = keyboard.nextLine();
        for (Item item:items){
            if (itemId.equals(item.getIdNumber())){
                items.remove(item);
            }
            else { System.out.println("Incorrect id number."); }
        }
        keyboard.close();
    }

    //getters and setters
    public int getNumber_Of_Item() { return number_Of_Item; }
    public List<Item> getItems() { return items; }
    public void setNumber_Of_Item(int number_Of_Item) { this.number_Of_Item = number_Of_Item; }
    public void setItems(List<Item> items) { this.items = items; }

    //Still getter and setter but prompts user to set the type of items they will have in their inventory and
    //add to list of types also a remove item type. Only for managers.
    protected void setItemTypes(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please list the item type.");
        String name = keyboard.nextLine();
        itemType type = new itemType();

        type.setItemTypeName(name);
        types.add(type);
        keyboard.close();
    }
    protected void removeItemTypes(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What item type are you removing ?");
        String itemtype = keyboard.nextLine();
        for (itemType type:types){
            if (itemtype.equals(type.getItemTypeName())){
                items.remove(type);
            }
            else { System.out.println("Incorrect item type."); }
        }
        keyboard.close();
    }

    //simple tostring to call alll the items in the inventory should read from database/file
    @Override
    public String toString() {
        return "The current inventory is:" + items;
    }
}