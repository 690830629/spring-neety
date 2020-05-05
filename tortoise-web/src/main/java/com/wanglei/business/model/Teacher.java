package com.wanglei.business.model;

import lombok.Data;

@Data
public class Teacher extends User {
    private String name="老师";

    private Integer age;

    @Override
    public String getUser1Name() {
        return this.getName();
    }
}
