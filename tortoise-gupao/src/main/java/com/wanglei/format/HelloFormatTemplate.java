/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.format;


import com.wanglei.autoconfiguration.HelloProperties;

import java.util.Map;
import java.util.Set;

public class HelloFormatTemplate {

    private FormatProcessor formatProcessor;

    private HelloProperties helloProperties;

    public HelloFormatTemplate(FormatProcessor formatProcessor, HelloProperties helloProperties) {
        this.formatProcessor = formatProcessor;
        this.helloProperties = helloProperties;
    }

    public <T> String doFormat(T obj) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Execute format").append("\n");
        stringBuilder.append("obj format result").append(formatProcessor.format(obj)).append("\n");
        stringBuilder.append("helloProperties: ").append(formatProcessor.format(helloProperties.getInfo())).append("\n");
        return stringBuilder.toString();
    }
}
