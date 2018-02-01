package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.model.Product;

/**
 * Created by bassiouny on 01/02/18.
 */

public class MyProductResponse extends ParentResponse {

    @SerializedName(DATA_KEY)
    private Product product;

    public Product getProduct() {
        if(product == null)
            product = new Product();
        return product;
    }
}
