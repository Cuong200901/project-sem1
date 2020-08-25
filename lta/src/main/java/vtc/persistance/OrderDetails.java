package vtc.persistance;

public class OrderDetails {
  private  int OrderDetailsId;
  private  int productsId;
  private  int amount;
   private int order_id;


    public int getOrderDetailsId() {
        return OrderDetailsId;
    }

    public void setOrderDetailsId(int OrderDetailsId) {
        this.OrderDetailsId = OrderDetailsId;
    }
    public int getproductsId() {
        return productsId;
    }

    public void setproductsId(int productsId) {
        this.productsId = productsId;
    }
    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }
    public int getorder_id() {
        return order_id;
    }

    public void setorder_id(int order_id) {
        this.order_id = order_id;
    }

}