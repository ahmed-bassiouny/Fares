package ahmed.bassiouny.fares.api.request;

import android.content.Context;
import android.util.Log;

import java.util.List;

import ahmed.bassiouny.fares.api.config.ApiConfig;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.BaseRequestInterface;
import ahmed.bassiouny.fares.api.response.LoginResponse;
import ahmed.bassiouny.fares.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bassiouny on 31/12/17.
 */

public class RequestAndResponse {
    public static final String errorConnection = "برجاء تاكد من اتصالك بالانترنت";

    // base request
    private static BaseRequestInterface baseRequestInterface = ApiConfig.getRetrofit().create(BaseRequestInterface.class);

    private static <T> void checkValidResult(int responseCode, boolean responseStatus, T object, String errorMsg, BaseResponseInterface baseResponseInterface) {
        // get response to check if request valid or not
        // get result object to pass it to base response interface
        if (responseCode == 200) {
            if (responseStatus) {
                baseResponseInterface.onSuccess(object);
            } else {
                baseResponseInterface.onFailed(errorMsg);
            }
        } else {
            // this case mean response code not equal 200
            baseResponseInterface.onFailed(errorMsg);
        }
    }
    public static void loginUser(String uid,String name,String email,String mobileToken,final BaseResponseInterface<User> anInterface){
        Call<LoginResponse> response = baseRequestInterface.loginUser(uid,name,email,mobileToken);
        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                checkValidResult(response.code(),response.body().getStatus(),
                        response.body().getUser(),response.body().getMessage(),anInterface);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                anInterface.onFailed(errorConnection);
            }
        });
    }
}