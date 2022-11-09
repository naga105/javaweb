package Model;

public class Cart {
    private String id;
    private String productName;
    private String productImg;
    private Double price;
    private int quantity;
    public static int idd=2;
    public static int getIdd(){
        return idd;
    }

    public Cart(String id, String productName, Double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public Cart(String id, String productName, Double price, int quantity, String productImg) {
        this.id = id;
        this.productName = productName;
        this.productImg = productImg;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void  setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String  toString() {
        return
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}'+'\n';
    }
}
