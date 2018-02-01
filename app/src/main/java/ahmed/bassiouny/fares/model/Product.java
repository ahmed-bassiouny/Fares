package ahmed.bassiouny.fares.model;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 11/01/18.
 */

public class Product {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("category_id")
    private int sectionId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private String price;
    @SerializedName("available_pieces")
    private String availablePieces;
    @SerializedName("wholesale_start_from")
    private String wholesaleCount;
    @SerializedName("wholesalePrice")
    private String wholesalePrice;
    @SerializedName("order_ready_at")
    private String orderReadyAt;
    @SerializedName("img_1")
    private String img_1;
    @SerializedName("img_2")
    private String img_2;
    @SerializedName("img_3")
    private String img_3;
    @SerializedName("img_4")
    private String img_4;

    public Product() {
    }

    public Product(int shopId, int sectionId, String name, String description, String price, String availablePieces, String wholesaleCount, String wholesalePrice, String orderReadyAt) {
        this.shopId = shopId;
        this.sectionId = sectionId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.availablePieces = availablePieces;
        this.wholesaleCount = wholesaleCount;
        this.wholesalePrice = wholesalePrice;
        this.orderReadyAt = orderReadyAt;
    }

    public int getId() {
        return id;
    }

    public int getShopId() {
        return shopId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public String getName() {
        return MyHelper.getValueFromString(name);
    }

    public String getDescription() {
        return MyHelper.getValueFromString(description);
    }

    public String getPrice() {
        return MyHelper.getValueFromString(price);
    }

    public String getAvailablePieces() {
        return MyHelper.getValueFromString(availablePieces);
    }

    public String getWholesaleCount() {
        return MyHelper.getValueFromString(wholesaleCount);
    }

    public String getWholesalePrice() {
        return MyHelper.getValueFromString(wholesalePrice);
    }

    public String getOrderReadyAt() {
        return MyHelper.getValueFromString(orderReadyAt);
    }

    public String getImg_1() {
        return MyHelper.getValueFromString(img_1);
    }

    public String getImg_2() {
        return MyHelper.getValueFromString(img_2);
    }

    public String getImg_3() {
        return MyHelper.getValueFromString(img_3);
    }

    public String getImg_4() {
        return MyHelper.getValueFromString(img_4);
    }
}
