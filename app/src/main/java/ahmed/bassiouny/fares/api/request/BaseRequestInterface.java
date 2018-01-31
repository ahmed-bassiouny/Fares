package ahmed.bassiouny.fares.api.request;

import ahmed.bassiouny.fares.api.response.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by bassiouny on 31/12/17.
 */

public interface BaseRequestInterface {

    String LOGIN = "user/login";

    @FormUrlEncoded
    @POST(LOGIN)
    Call<LoginResponse> loginUser(@Field("uid") String userId,
                                 @Field("name") String name,
                                 @Field("email") String email,
                                 @Field("mobile_token") String mobileToken);
   /*
    @FormUrlEncoded
    @Headers(HEADER_KEY)
    @POST(RATE)
    Call<ParentResponse> rateTask(@Header(AUTHORIZATION) String token,
                                      @Field(RateRequest.STAFF_ID) int userId,
                                      @Field(RateRequest.SERVICE_ID) int taskId,
                                      @Field(RateRequest.COMMENT) String comment,
                                      @Field(RateRequest.RATE) int rate);
*/
}
