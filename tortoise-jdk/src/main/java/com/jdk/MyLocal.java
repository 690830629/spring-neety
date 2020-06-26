package com.jdk;

import java.util.Locale;

public class MyLocal
{
    public static void main(String[] args) {
        Locale[] ls = Locale.getAvailableLocales();

        for (Locale locale:ls) {
            System.out.println("locale :"+locale);
        }
    }
}
