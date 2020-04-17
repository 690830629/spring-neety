package com.wanglei.business.Util;

import java.math.BigDecimal;

public class CalculateUtil {
    public static void main(String[] args) {
        Integer a=300;
        Integer b=400;
        for(int i=0;i<7;i++){ BigDecimal divide = BigDecimal.valueOf(b - a).divide(BigDecimal.valueOf(a),i,BigDecimal.ROUND_UP);
            System.out.println(divide);

        }




    }
}
