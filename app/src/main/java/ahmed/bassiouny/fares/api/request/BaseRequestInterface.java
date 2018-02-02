package ahmed.bassiouny.fares.api.request;

import ahmed.bassiouny.fares.api.response.LoginResponse;
import ahmed.bassiouny.fares.api.response.MyProductResponse;
import ahmed.bassiouny.fares.api.response.MyShopListResponse;
import ahmed.bassiouny.fares.api.response.MyShopResponse;
import ahmed.bassiouny.fares.api.response.ParentResponse;
import ahmed.bassiouny.fares.api.response.ProductListResponse;
import ahmed.bassiouny.fares.api.response.SectionsResponse;
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
    String SECTION = "category/get-all";
    String CREATE_PRODUCT = "product/create";
    String  GET_SHOP = "shop/show";
    String GET_PRODUCT = "product/show-products";
    String UPDATE_PRODUCT = "product/update";

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


    @GET(SECTION)
    Call<SectionsResponse> getSections();


    @FormUrlEncoded
    @POST(CREATE_PRODUCT)
    Call<MyProductResponse> createProduct(@Header(AUTHORIZATION) String token,
                                          @Field("shop_id") int shopId,
                                          @Field("category_id") int sectionId,
                                          @Field("name") String name,
                                          @Field("description") String decscription,
                                          @Field("price") String price,
                                          @Field("wholesale_price") String wholesalePrice,
                                          @Field("wholesale_start_from") String wholesaleCount,
                                          @Field("available_pieces") String availablePieces,
                                          @Field("order_ready_at") String readyAt);


    @FormUrlEncoded
    @POST(GET_SHOP)
    Call<SectionsResponse> getShop(@Header(AUTHORIZATION) String token,
                                      @Field("shop_id") int shopId);

    @FormUrlEncoded
    @POST(GET_PRODUCT)
    Call<ProductListResponse> getProducts(@Field("shop_id") int shopId,
                                          @Field("category_id") int sectionId);


    @FormUrlEncoded
    @POST(CREATE_PRODUCT)
    Call<MyProductResponse> updateProduct(@Header(AUTHORIZATION) String token,
                                          @Field("product_id") int productId,
                                          @Field("name") String name,
                                          @Field("description") String decscription,
                                          @Field("price") String price,
                                          @Field("wholesale_price") String wholesalePrice,
                                          @Field("wholesale_start_from") String wholesaleCount,
                                          @Field("available_pieces") String availablePieces,
                                          @Field("order_ready_at") String readyAt);
}
