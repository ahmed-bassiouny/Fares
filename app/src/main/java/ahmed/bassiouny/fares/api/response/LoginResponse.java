package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import ahmed.bassiouny.fares.model.User;

/**
 * Created by bassiouny on 31/01/18.
 */

public class LoginResponse extends ParentResponse {
    @SerializedName(DATA_KEY)
    private User user;

    public User getUser() {
        if (user == null)
            user = new User();
        return user;
    }
}
