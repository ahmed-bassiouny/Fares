package ahmed.bassiouny.fares.api.request;

import ahmed.bassiouny.fares.api.response.LoginResponse;
import ahmed.bassiouny.fares.api.response.MyShopListResponse;
import ahmed.bassiouny.fares.api.response.MyShopResponse;
import ahmed.bassiouny.fares.api.response.ParentResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by bassiouny on 31/12/17.
 */

public interface BaseRequestInterface {

    String AUTHORIZATION = "Authorization";
    String LOGIN = "user/login";
    String CREATE_SHOP = "shop/create";
    String MY_SHOP = "shop/my-shops";
    String UPDATE_SHOP = "shop/update";

    @FormUrlEncoded
    @POST(LOGIN)
    Call<LoginResponse> loginUser(@Field("uid") String userId,
                                  @Field("name") String name,
                                  @Field("email") String email,
                                  @Field("mobile_token") String mobileToken);

    @FormUrlEncoded
    @POST(CREATE_SHOP)
    Call<ParentResponse> createShop(@Header(AUTHORIZATION) String token,
                                    @Field("phone") String phone);

    @GET(MY_SHOP)
    Call<MyShopListResponse> getMyShop(@Header(AUTHORIZATION) String token);

    @FormUrlEncoded
    @POST(UPDATE_SHOP)
    Call<MyShopResponse> updateMyShop(@Header(AUTHORIZATION) String token,
                                      @Field("shop_id") int shopId,
                                      @Field("name") String shopName,
                                      @Field("description") String shopDescription,
                                      @Field("phone") String phone);
}
