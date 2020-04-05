package com.wanglei.business.Util;

import java.math.BigDecimal;

public class StringUtils {
    public static void main(String[] args) {

        Double a=1.91;
        Double b=0.31;
        Double c=2.39;
        System.out.println(a+b+c);
        System.out.println(a+c+b);
        System.out.println(new BigDecimal(a.toString()));
        System.out.println(a.toString());
        System.out.println(BigDecimal.valueOf(a.doubleValue()));
    }
}
