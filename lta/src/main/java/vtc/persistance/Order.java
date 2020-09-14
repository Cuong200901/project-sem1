package vtc.persistance;

public class Order {

    private int orderId;
    private String time;
    private String orderStatus;
    private int accountId;
    private String note;
    private int cardNumber;
   
    private double totalBill;
   

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getcardNumber() {
        return cardNumber;
    }

    public void setcardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double gettotalBill() {
        return totalBill;
    }

    public void settotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public String getorderstatus() {
        return orderStatus;
    }

    public void setorderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
