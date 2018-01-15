package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 11/01/18.
 */

public class ProductCart {
    private Product product;
    private String shopName;
    private int quantity;

    public ProductCart(Product product, String shopName, int quantity) {
        this.product = product;
        this.shopName = shopName;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public String getShopName() {
        return shopName;
    }

    public String getQuantity() {
        return String.valueOf(quantity);
    }

    public String getTotal() {
        return String.valueOf(quantity * Float.parseFloat(product.getPrice()));
    }
}
