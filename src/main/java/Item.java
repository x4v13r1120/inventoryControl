
public class Item {

    //attributes of item
    private String item_name;
    private int item_Id;
    private int price_per_unit;
    private String item_type;
    private int quantity;

    //GETTERS AND SETTERS
    public int getPricePerUnit() {
        return price_per_unit;
    }

    public void setPricePerUnit(int price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public int getIdNumber() {
        return item_Id;
    }

    public void setIdNumber(int idNumber) {
        this.item_Id = idNumber;
    }

    public String getName() {
        return item_name;
    }

    public void setName(String name) {
        this.item_name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
}