package com.dreamerlxb.retrofitdemo;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
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

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setBackgroundColor(Color.WHITE);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setInActiveColor(R.color.black);

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener(){
            @Override
            public void onTabSelected(int position) {
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        BottomNavigationItem home = new BottomNavigationItem(R.mipmap.home_selected, "首页")
                .setInactiveIconResource(R.mipmap.home)
                .setActiveColor(Color.RED);
        TextBadgeItem bi = new TextBadgeItem();
        bi.setText("2");
        BottomNavigationItem discovery = new BottomNavigationItem(R.mipmap.discover_selected, "发现")
                .setInactiveIconResource(R.mipmap.discover)
                .setActiveColor(Color.YELLOW)
                .setBadgeItem(bi);
        BottomNavigationItem message = new BottomNavigationItem(R.mipmap.message_selected, "消息")
                .setInactiveIconResource(R.mipmap.message)
                .setActiveColor(Color.GREEN);
        BottomNavigationItem me = new BottomNavigationItem(R.mipmap.me_selected, "我")
                .setInactiveIconResource(R.mipmap.me)
                .setActiveColor(Color.BLUE);
        bottomNavigationBar
                .addItem(home)
                .addItem(discovery)
                .addItem(message)
                .addItem(me)
                .initialise();
    }

    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MarkTypeService markTypeService = retrofit.create(MarkTypeService.class);
//        JSONObject object = new JSONObject().put("order", "typeGroupId");
        Call<List<MarkType>> call = markTypeService.getMarkTypes("{\"order\": \"typeGroupId\"}");
//        Log.i()call.request().url().toString();
        call.enqueue(new Callback<List<MarkType>>() {
            @Override
            public void onResponse(@NonNull Call<List<MarkType>> call, @NonNull Response<List<MarkType>> response) {
                Log.i("==Response==","return:"+ response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<List<MarkType>> call, @NonNull Throwable t) {
                Log.i("==Error==","return:"+ t.toString());
            }
        });
    }
}
