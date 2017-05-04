package com.dreamerlxb.retrofitdemo.service;

import com.dreamerlxb.retrofitdemo.entity.MarkType;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sxb on 2017/5/2.
 */

public interface MarkTypeService {
    @GET("MHMarkType")
    Call<List<MarkType>> getMarkTypes(@Query("filter") String object);
}
