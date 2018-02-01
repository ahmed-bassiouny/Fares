package ahmed.bassiouny.fares.api.request;

import android.content.Context;

import java.util.List;

import ahmed.bassiouny.fares.api.config.ApiConfig;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.response.LoginResponse;
import ahmed.bassiouny.fares.api.response.MyShopListResponse;
import ahmed.bassiouny.fares.api.response.MyShopResponse;
import ahmed.bassiouny.fares.api.response.ParentResponse;
import ahmed.bassiouny.fares.api.response.SectionsResponse;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.model.User;
import ahmed.bassiouny.fares.utils.UserSharedPref;
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
    public static void createShop(Context context,String phone,final BaseResponseInterface<ParentResponse> anInterface){
        Call<ParentResponse> response = baseRequestInterface.createShop(UserSharedPref.getTokenWithHeader(context),phone);
        response.enqueue(new Callback<ParentResponse>() {
            @Override
            public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {
                checkValidResult(response.code(),response.body().getStatus(),
                        response.body(),response.body().getMessage(),anInterface);
            }

            @Override
            public void onFailure(Call<ParentResponse> call, Throwable t) {
                anInterface.onFailed(errorConnection);
            }
        });
    }
    public static void getMyShop(Context context,final BaseResponseInterface<List<Shop>> anInterface){
        Call<MyShopListResponse> response = baseRequestInterface.getMyShop(UserSharedPref.getTokenWithHeader(context));
        response.enqueue(new Callback<MyShopListResponse>() {
            @Override
            public void onResponse(Call<MyShopListResponse> call, Response<MyShopListResponse> response) {
                checkValidResult(response.code(),response.body().getStatus(),
                        response.body().getShops(),response.body().getMessage(),anInterface);
            }

            @Override
            public void onFailure(Call<MyShopListResponse> call, Throwable t) {
                anInterface.onFailed(errorConnection);
            }
        });
    }

    public static void updateMyShop(Context context,Shop shop,final BaseResponseInterface<Shop> anInterface){
        Call<MyShopResponse> response = baseRequestInterface.updateMyShop(UserSharedPref.getTokenWithHeader(context)
        ,shop.getId(),shop.getName(),shop.getDescription(),shop.getPhone());
        response.enqueue(new Callback<MyShopResponse>() {
            @Override
            public void onResponse(Call<MyShopResponse> call, Response<MyShopResponse> response) {
                checkValidResult(response.code(),response.body().getStatus(),
                        response.body().getShop(),response.body().getMessage(),anInterface);
            }

            @Override
            public void onFailure(Call<MyShopResponse> call, Throwable t) {
                anInterface.onFailed(errorConnection);
            }
        });
    }

    public static void getSections(final BaseResponseInterface<List<Section>> anInterface){
        Call<SectionsResponse> response = baseRequestInterface.getSections();
        response.enqueue(new Callback<SectionsResponse>() {
            @Override
            public void onResponse(Call<SectionsResponse> call, Response<SectionsResponse> response) {
                checkValidResult(response.code(),response.body().getStatus(),
                        response.body().getSections(),response.body().getMessage(),anInterface);
            }

            @Override
            public void onFailure(Call<SectionsResponse> call, Throwable t) {
                anInterface.onFailed(errorConnection);
            }
        });
    }
}