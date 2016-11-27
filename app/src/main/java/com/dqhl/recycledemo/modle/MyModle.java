package com.dqhl.recycledemo.modle;

/**
 * Created by guanluocang on 2016/11/24.
 */
public class MyModle {
    private String id;

    @Override
    public String toString() {
        return "MyModle{" +
                "id='" + id + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
