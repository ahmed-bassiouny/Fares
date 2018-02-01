package ahmed.bassiouny.fares.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 12/01/18.
 */

public class Section {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("products")
    private List<Product> products;

    public int getId() {
        return id;
    }

    public String getName() {
        return MyHelper.getValueFromString(name);
    }

    public List<Product> getProducts() {
        if (products == null)
            products = null;
        return products;
    }
}
