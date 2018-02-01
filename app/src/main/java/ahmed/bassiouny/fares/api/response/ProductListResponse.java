package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.model.Product;

/**
 * Created by bassiouny on 01/02/18.
 */

public class ProductListResponse extends ParentResponse {
    @SerializedName(DATA_KEY)
    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null)
            products = new ArrayList<>();
        return products;
    }
}
