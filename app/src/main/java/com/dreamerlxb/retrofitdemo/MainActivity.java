package com.dreamerlxb.retrofitdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dreamerlxb.retrofitdemo.entity.MarkType;
import com.dreamerlxb.retrofitdemo.service.MarkTypeService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//import static com.ashokvarma.bottomnavigation.BottomNavigationBar.MODE_FIXED;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setBackgroundColor(Color.WHITE);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);

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

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home_selected, "Home").setInactiveIconResource(R.mipmap.home))
                .addItem(new BottomNavigationItem(R.mipmap.discover_selected, "Books").setInactiveIconResource(R.mipmap.discover))
                .addItem(new BottomNavigationItem(R.mipmap.message_selected, "Music").setInactiveIconResource(R.mipmap.message))
                .addItem(new BottomNavigationItem(R.mipmap.me_selected, "Games").setInactiveIconResource(R.mipmap.me))
                .initialise();
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
