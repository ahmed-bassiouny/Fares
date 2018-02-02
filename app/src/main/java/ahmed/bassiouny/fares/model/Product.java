package ahmed.bassiouny.fares.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 11/01/18.
 */

public class Product implements Parcelable {

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
    @SerializedName("wholesale_price")
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
    @SerializedName("user_id")
    private int ownerId;

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

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.shopId);
        dest.writeInt(this.sectionId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.price);
        dest.writeString(this.availablePieces);
        dest.writeString(this.wholesaleCount);
        dest.writeString(this.wholesalePrice);
        dest.writeString(this.orderReadyAt);
        dest.writeString(this.img_1);
        dest.writeString(this.img_2);
        dest.writeString(this.img_3);
        dest.writeString(this.img_4);
        dest.writeInt(this.ownerId);
    }

    protected Product(Parcel in) {
        this.id = in.readInt();
        this.shopId = in.readInt();
        this.sectionId = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.price = in.readString();
        this.availablePieces = in.readString();
        this.wholesaleCount = in.readString();
        this.wholesalePrice = in.readString();
        this.orderReadyAt = in.readString();
        this.img_1 = in.readString();
        this.img_2 = in.readString();
        this.img_3 = in.readString();
        this.img_4 = in.readString();
        this.ownerId = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
