package com.wanglei.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {

    private String name="学生";

    private Integer age;

    @Override
    public String getUser1Name() {
        return this.getName();
    }
}

