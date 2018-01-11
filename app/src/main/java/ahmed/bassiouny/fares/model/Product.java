package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 11/01/18.
 */

public class Product {
    private String name;
    private String description;
    private String price;
    private int photo;

    public Product(String name, String description, String price, int photo) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getPhoto() {
        return photo;
    }
}
