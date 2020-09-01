package vtc.persistance;

public class OrderDetails {
    private int orderDetailsId;
    private int productId;
    private int amount;
    private int orderId;


    public int getorderDetailsId() {
        return orderDetailsId;
    }

    public void setorderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }
    public int getproductId() {
        return productId;
    }

    public void setproductId(int productId) {
        this.productId = productId;
    }
    public int getamount() {
        return  amount;
    }

    public void setamount(int  amount) {
        this. amount =  amount;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}