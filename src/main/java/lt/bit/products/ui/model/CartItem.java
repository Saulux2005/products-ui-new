package lt.bit.products.ui.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CartItem {

    private UUID productId;
    private String productName;
    private BigDecimal productPrice;
    private int count;


    public CartItem(UUID productId, String productName, BigDecimal productPrice, int count) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productName='" + productName + '\'' +
                ", count=" + count +
                '}';
    }



    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getTotalPrice() {
        return productPrice.multiply(BigDecimal.valueOf(getCount()));
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
