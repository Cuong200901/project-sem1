package vtc.persistance;

public class Product {
    private int productId;
    private String productName; 
    private Double price; 
    private String category;
    private int productsInStock;

    public int getProductsInStock() {
        return productsInStock;
    }

    public void setProductsInStock(int productsInStock) {

        this.productsInStock = productsInStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
   
     

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
