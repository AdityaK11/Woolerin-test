package com.astansia.woolerin_test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    String Base_url = "https://api.prokerala.com/v1/astrology/";

    @Headers({"Authorization: Bearer e56769488793cea2c47c14d37a27b539af3f1710ea5b9efeec9c8c145dd59230"})
    @GET("panchang")
    Call<ResponseBody> getResult(
            @Query("ayanamsa") String ayanamsa,
            @Query("datetime") String datetimr,
            @Query("coordinates") String coordinates,
            @Query("userid") int userid
    );
}
