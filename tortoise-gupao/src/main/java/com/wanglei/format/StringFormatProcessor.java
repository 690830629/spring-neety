/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.format;

import java.util.Objects;

public class StringFormatProcessor implements FormatProcessor {
    @Override
    public <T> String format(T obj) {
        return "StringFormatProcessor" + Objects.toString(obj);
    }
}
