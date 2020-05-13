package com.wanglei.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer height;


    public boolean isHeighter() {
        return this.height > 7;
    }


    public String getUser1Name() {
        return null;
    }
}
