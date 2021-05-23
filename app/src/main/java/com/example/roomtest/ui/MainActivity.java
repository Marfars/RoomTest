package com.example.roomtest.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.roomtest.R;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initView();
    }

    private void initView() {
        // 初始化控件
        Button btnInsertAllFieldsData = this.findViewById(R.id.btnInsertAllFieldsData);
        Button btnInsertNameFieldData = this.findViewById(R.id.btnInsertNameField);
        Button btnUpdateNameWithRoomApi = this.findViewById(R.id.btnUpdateNameWithRoomApi);
        Button btnUpdateNameWithSQL = this.findViewById(R.id.btnUpdateNameWithSQL);
        TextView tvShowDatabaseOperationResult = this.findViewById(R.id.tvShowResult);
        // 按钮添加点击事件
        btnInsertAllFieldsData.setOnClickListener(v -> viewModel.insertAllFieldsData());
        btnInsertNameFieldData.setOnClickListener(v -> viewModel.insertNameFieldsData());
        btnUpdateNameWithRoomApi.setOnClickListener(v -> viewModel.updateNameFieldWithRoomApi());
        btnUpdateNameWithSQL.setOnClickListener(v -> viewModel.updateNameFieldWithSQL());
        // 展示数据库操作结果
        viewModel.databaseOperationResult.observe(this, tvShowDatabaseOperationResult::setText);
    }
}