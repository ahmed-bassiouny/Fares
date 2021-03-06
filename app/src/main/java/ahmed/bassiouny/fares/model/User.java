package ahmed.bassiouny.fares.model;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.utils.MyHelper;

/**
 * Created by bassiouny on 31/01/18.
 */

public class User {

    @SerializedName("id")
    private int id; // this is generated by web api
    @SerializedName("uid")
    private String userId; // this id generated by firebase auth
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("mobile_token")
    private String mobileToken;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("api_token")
    private String apiToken;
    @SerializedName("has_shop")
    private boolean hasShop;
    @SerializedName("profile_img")
    private String avatar;
    @SerializedName("is_online")
    private int online;

    public int getId() {
        return id;
    }

    public String getUserId() {
        return MyHelper.getValueFromString(userId);
    }

    public String getName() {
        return MyHelper.getValueFromString(name);
    }

    public String getEmail() {
        return MyHelper.getValueFromString(email);
    }

    public String getMobileToken() {
        return MyHelper.getValueFromString(mobileToken);
    }

    public String getPhone() {
        return MyHelper.getValueFromString(phone);
    }

    public String getAddress() {
        return MyHelper.getValueFromString(address);
    }

    public String getCity() {
        return MyHelper.getValueFromString(city);
    }

    public String getApiToken() {
        return MyHelper.getValueFromString(apiToken);
    }

    public boolean isHasShop() {
        return hasShop;
    }

    public String getAvatar() {
        return MyHelper.getValueFromString(avatar);
    }

    public boolean isOnline(){
        return online == 1;
    }
}
