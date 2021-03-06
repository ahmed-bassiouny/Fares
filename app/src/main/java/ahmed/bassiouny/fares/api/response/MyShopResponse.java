package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.model.Shop;

/**
 * Created by bassiouny on 31/01/18.
 */

public class MyShopResponse extends ParentResponse {
    @SerializedName(DATA_KEY)
    private Shop shop;

    public Shop getShop() {
        if(shop == null)
            shop = new Shop();
        return shop;
    }
}
