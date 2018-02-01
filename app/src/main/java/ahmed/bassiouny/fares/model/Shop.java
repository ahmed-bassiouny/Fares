package ahmed.bassiouny.fares.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 12/01/18.
 */

public class Shop implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("profile_img")
    private String photo;
    @SerializedName("phone")
    private String phone;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return MyHelper.getValueFromString(name);
    }

    public String getDescription() {
        return MyHelper.getValueFromString(description);
    }

    public String getPhoto() {
        return MyHelper.getValueFromString(photo);
    }

    public String getPhone() {
        return MyHelper.getValueFromString(phone);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.userId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.photo);
        dest.writeString(this.phone);
    }

    public Shop() {
    }

    protected Shop(Parcel in) {
        this.id = in.readInt();
        this.userId = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readString();
        this.phone = in.readString();
    }

    public static final Parcelable.Creator<Shop> CREATOR = new Parcelable.Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel source) {
            return new Shop(source);
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
        }
    };
}
