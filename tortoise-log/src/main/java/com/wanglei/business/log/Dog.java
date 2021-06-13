/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.business.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dog {
    private static final Logger logger = LogManager.getLogger(Dog.class);

    public static void main(String[] args) {
        logger.warn("this is warn level");
        logger.info("this is info level");
        logger.error("this is error level");
    }
}
