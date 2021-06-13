/*
 * Copyright (C) 2020 iQIYI.COM - All Rights Reserved.
 * This file is part of Pizza project. Unauthorized copy
 * of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 *
 * Author(s): INQ Team <iig_ipd_inq@qiyi.com>
 */
package com.wanglei.autoconfiguration;

import com.wanglei.format.FormatProcessor;
import com.wanglei.format.HelloFormatTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(HelloProperties.class)
@Configurable
public class HelloAutoConfiguration {

    @Bean
    public HelloFormatTemplate helloFormatTemplate(HelloProperties helloProperties, FormatProcessor formatProcessor) {
        return new HelloFormatTemplate(formatProcessor, helloProperties);
    }

}
