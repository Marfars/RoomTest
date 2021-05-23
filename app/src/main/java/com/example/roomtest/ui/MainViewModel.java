package com.example.roomtest.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomtest.core.Api;
import com.example.roomtest.core.BaseCallback;
import com.example.roomtest.core.BaseResponse;
import com.example.roomtest.database.model.OfficialAccountBean;
import com.example.roomtest.database.model.OfficialAccountNameBean;

import java.util.List;

import retrofit2.Call;

public class MainViewModel extends ViewModel {
    private final String TAG = "MainViewModel";
    private final MutableLiveData<String> _databaseOperationResult = new MutableLiveData<>();
    public final LiveData<String> databaseOperationResult = _databaseOperationResult;
    private final DatabaseRepository repository;

    public MainViewModel() {
        repository = new DatabaseRepository();
        _databaseOperationResult.postValue("");
    }

    public void insertAllFieldsData() {
        Api.getApiService().getOfficialAccountList().enqueue(new BaseCallback<List<OfficialAccountBean>>() {
            @Override
            public void onFailure(Call<BaseResponse<List<OfficialAccountBean>>> call, int code, String errorMessage) {
                Log.d(TAG, "onFailure: " + errorMessage);
                changeShowText("网络请求失败\n");
            }

            @Override
            public void onResponse(Call<BaseResponse<List<OfficialAccountBean>>> call, List<OfficialAccountBean> response) {
                repository.insertAllFields(response);
                changeShowText("本次请求数据的所有字段已被插入数据库\n");
            }
        });
    }

    public void insertNameFieldsData() {
        repository.clearDatabase();
        changeShowText("数据库已被清空\n");
        Api.getApiService().getOfficialAccountList().enqueue(new BaseCallback<List<OfficialAccountBean>>() {
            @Override
            public void onFailure(Call<BaseResponse<List<OfficialAccountBean>>> call, int code, String errorMessage) {
                Log.d(TAG, "onFailure: " + errorMessage);
                changeShowText("网络请求失败\n");
            }

            @Override
            public void onResponse(Call<BaseResponse<List<OfficialAccountBean>>> call, List<OfficialAccountBean> response) {
                repository.insertNameFields(response);
                changeShowText("本次请求数据的Name字段已被插入数据库\n");
            }
        });
    }

    public void updateNameFieldWithRoomApi() {
        OfficialAccountBean firstDataInDatabase = repository.queryFirstData();
        if (firstDataInDatabase == null) {
            changeShowText("数据库中并无数据，无法改变\n");
        } else {
            repository.updateNameFieldWithRoomApi(new OfficialAccountNameBean(firstDataInDatabase.getId(), firstDataInDatabase.getName() + "QAQ"));
            changeShowText("数据库中第一个数据的Name字段已变成" + repository.queryFirstData().getName() + "\n");
        }
    }

    public void updateNameFieldWithSQL() {
        OfficialAccountBean firstDataInDatabase = repository.queryFirstData();
        if (firstDataInDatabase == null) {
            changeShowText("数据库中并无数据，无法改变\n");
        } else {
            repository.updateNameFieldWithSQL(new OfficialAccountNameBean(firstDataInDatabase.getId(), firstDataInDatabase.getName() + "QAQ"));
            changeShowText("数据库中第一个数据的Name字段已变成" + repository.queryFirstData().getName() + "\n");
        }
    }

    private void changeShowText(String content) {
        _databaseOperationResult.postValue(_databaseOperationResult.getValue() + content);
    }
}
