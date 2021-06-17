/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLog {
    static final Logger logger = LoggerFactory.getLogger(MyLog.class);

    public static void main(String[] args) {
        logger.info("this is a logback demo");
    }
}
