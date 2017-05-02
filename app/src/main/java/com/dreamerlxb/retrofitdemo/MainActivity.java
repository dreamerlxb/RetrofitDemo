package com.dreamerlxb.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dreamerlxb.retrofitdemo.entity.MarkType;
import com.dreamerlxb.retrofitdemo.service.MarkTypeService;

import java.util.List;

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
    }

    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MarkTypeService markTypeService = retrofit.create(MarkTypeService.class);
        Call<List<MarkType>> call = markTypeService.getMarkTypes();
        call.enqueue(new Callback<List<MarkType>>() {
            @Override
            public void onResponse(Call<List<MarkType>> call, Response<List<MarkType>> response) {
                Log.i("==Response==","return:"+ response.body().toString());
            }

            @Override
            public void onFailure(Call<List<MarkType>> call, Throwable t) {
                Log.i("==Error==","return:"+ t.toString());
            }
        });
    }
}
