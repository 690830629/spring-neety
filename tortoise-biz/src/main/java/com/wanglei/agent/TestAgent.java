/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.agent;

import com.wanglei.config.Config;

import java.util.Scanner;

public class TestAgent {
    public static void main(String[] args) {
        System.out.println("按数字键 1 调用测试方法");
        System.out.println("后写");
        while (true) {
            Scanner reader = new Scanner(System.in);
            int number = reader.nextInt();
            if (number == 1) {
                Config person = new Config();
                person.getCar();
            }
        }
    }
}
