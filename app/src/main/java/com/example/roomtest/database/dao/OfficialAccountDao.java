package com.example.roomtest.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomtest.database.model.OfficialAccountBean;
import com.example.roomtest.database.model.OfficialAccountNameBean;

import java.util.List;

@Dao
public interface OfficialAccountDao {

    @Update(entity = OfficialAccountBean.class)
    int updateOfficialAccountNameWithRoomApi(OfficialAccountNameBean accountNameBeans);

    @Query("UPDATE official_account SET name = :newName where id = :id")
    void updateOfficialAccountNameWithSql(Integer id, String newName);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllFields(List<OfficialAccountBean> officialAccountBeanList);

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = OfficialAccountBean.class)
    void insertNameField(List<OfficialAccountNameBean> officialAccountNameBeanList);

    @Query("select * From official_account")
    List<OfficialAccountBean> queryAllData();

    @Delete
    void deleteDataList(List<OfficialAccountBean> officialAccountBeanList);
}
