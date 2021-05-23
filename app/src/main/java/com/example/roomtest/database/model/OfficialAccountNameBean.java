package com.example.roomtest.database.model;

/**
 * @author lenovo
 * 创建时间： 2021/5/22 15:33
 * 类描述：
 */
public class OfficialAccountNameBean {

    public OfficialAccountNameBean(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
