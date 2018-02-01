package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.model.Shop;

/**
 * Created by bassiouny on 31/01/18.
 */

public class MyShopListResponse extends ParentResponse {
    @SerializedName(DATA_KEY)
    private List<Shop> shops;

    public List<Shop> getShops() {
        if (shops == null)
            shops = new ArrayList<>();
        return shops;
    }
}
