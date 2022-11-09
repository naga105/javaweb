package Model;

public class Product {
    private String id;
    private String productName;
    private String productType;
    private String productImg;
    private Double price;

    public Product(String id, String productName, String productType, String productImg, Double price) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.productImg = productImg;
        this.price = price;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productImg='" + productImg + '\'' +
                ", price=" + price +
                '}'+'\n';
    }
}
