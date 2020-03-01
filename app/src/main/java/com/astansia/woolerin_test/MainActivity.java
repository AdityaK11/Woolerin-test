package com.astansia.woolerin_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView res = findViewById(R.id.response);
        TextView req = findViewById(R.id.request);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        final Call<ResponseBody> call = api.getResult("1","2004-02-06T15:19:21Z","13.0878,80.2785",1);

        req.setText(call.request().url().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    res.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("-----success---",response.message());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //String s = response.body();
                res.setText("Failure "+ t.getMessage());
                Log.d("--------failure-----",t.getMessage());
            }
        });

    }
}
