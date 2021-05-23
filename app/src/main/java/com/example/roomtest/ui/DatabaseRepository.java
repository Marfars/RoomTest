package com.example.roomtest.ui;

import com.example.roomtest.database.AppDatabase;
import com.example.roomtest.database.dao.OfficialAccountDao;
import com.example.roomtest.database.model.OfficialAccountBean;
import com.example.roomtest.database.model.OfficialAccountNameBean;

import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private final OfficialAccountDao officialAccountDao = AppDatabase.getInstance().getOfficialAccountDao();

    public void insertAllFields(List<OfficialAccountBean> officialAccountBeanList) {
        officialAccountDao.insertAllFields(officialAccountBeanList);
    }

    public void insertNameFields(List<OfficialAccountBean> officialAccountBeanList) {
        ArrayList<OfficialAccountNameBean> officialAccountNameBeanArrayList = new ArrayList<>();
        for (int i = 0; i < officialAccountBeanList.size(); i++) {
            OfficialAccountBean officialAccountBean = officialAccountBeanList.get(i);
            officialAccountNameBeanArrayList.add(new OfficialAccountNameBean(officialAccountBean.getId(), officialAccountBean.getName()));
        }
        officialAccountDao.insertNameField(officialAccountNameBeanArrayList);
    }

    public void clearDatabase() {
        officialAccountDao.deleteDataList(officialAccountDao.queryAllData());
    }

    public OfficialAccountBean queryFirstData() {
        List<OfficialAccountBean> officialAccountBeans = officialAccountDao.queryAllData();
        if (!officialAccountBeans.isEmpty()) {
            return officialAccountBeans.get(0);
        }
        return null;
    }

    public void updateNameFieldWithRoomApi(OfficialAccountNameBean officialAccountNameBean) {
        officialAccountDao.updateOfficialAccountNameWithRoomApi(officialAccountNameBean);
    }

    public void updateNameFieldWithSQL(OfficialAccountNameBean officialAccountNameBean) {
        officialAccountDao.updateOfficialAccountNameWithSql(officialAccountNameBean.getId(), officialAccountNameBean.getName());
    }
}
