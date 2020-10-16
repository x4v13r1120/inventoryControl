import java.util.ArrayList;

public class Order {
    private int orderNum;
    private String CustoName;
    private String orderId;
    private ArrayList<Meal> meals;


    public String getCustoName() {
        return CustoName;
    }

    public void setCustoName(String custoName) {
        CustoName = custoName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }
}
