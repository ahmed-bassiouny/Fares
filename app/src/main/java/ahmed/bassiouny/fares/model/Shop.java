package ahmed.bassiouny.fares.model;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 12/01/18.
 */

public class Shop {

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
}
