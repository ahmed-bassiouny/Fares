package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 15/01/18.
 */

public class ShippingCompany {

    private String name;
    private int price;

    public ShippingCompany(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public String getPriceString() {
        return price+" جنية";
    }
}
