package com.dreamerlxb.retrofitdemo.service;

import com.dreamerlxb.retrofitdemo.entity.MarkType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sxb on 2017/5/2.
 */

public interface MarkTypeService {
    @GET("MHMarkType")
    Call<List<MarkType>> getMarkTypes();
}
