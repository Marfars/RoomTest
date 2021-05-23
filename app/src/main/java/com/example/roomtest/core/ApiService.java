package com.example.roomtest.core;

import com.example.roomtest.database.model.OfficialAccountBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lenovo
 * 创建时间： 2021/5/22 15:11
 * 类描述：
 */
public interface ApiService {

    @GET("wxarticle/chapters/json")
    Call<BaseResponse<List<OfficialAccountBean>>> getOfficialAccountList();
}
