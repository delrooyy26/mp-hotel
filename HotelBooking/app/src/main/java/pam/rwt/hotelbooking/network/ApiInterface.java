package pam.rwt.hotelbooking.network;


import java.util.ArrayList;

import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {
    /*--------Image Upload  API---------------------------*/



    @Multipart
    @POST("hotelUsers.php")
    Call<String> postData(@Part("name") RequestBody name,
                                      @Part("email") RequestBody email,
                                      @Part("phone") RequestBody phone,
                                      @Part("address") RequestBody address,
                                      @Part("numberofperson") RequestBody numberofperson,
                                      @Part("roomType") RequestBody roomType,
                                      @Part("checkin") RequestBody checkin,
                                      @Part("checkout") RequestBody checkout,
                                      @Part("num") RequestBody num

    );

//    @POST("getUserData.php")
//    Call<ArrayList<SaversDataResponse>> getData();
}
