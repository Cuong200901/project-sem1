package vtc.persistance;

public class OrderDetails {
    private int productId;
    private int amount;
    private int orderId;
    private double money;



    public int getproductId() {
        return productId;
    }

    public void setproductId(int productId) {
        this.productId = productId;
    }

    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getmoney() {
        return money;
    }

    public void setmoney(double money) {
        this.money = money;
    }



}