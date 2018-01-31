package ahmed.bassiouny.fares.api.response;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.model.Shop;

/**
 * Created by bassiouny on 31/01/18.
 */

public class MyShopResponse extends ParentResponse {
    private List<Shop> shops;

    public List<Shop> getShops() {
        if (shops == null)
            shops = new ArrayList<>();
        return shops;
    }
}
