package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 15/01/18.
 */

public class ShippingCompanies {

    private String name;
    private int price;

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
