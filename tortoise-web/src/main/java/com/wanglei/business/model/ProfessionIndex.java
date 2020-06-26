package com.wanglei.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class ProfessionIndex  {
    /**
     * 主键
     */
    private Integer profession_IndexID;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 猫眼指数
     */
    private Integer maoYanIndex;

    /**
     * 微信指数
     */
    private Integer weChatIndex;

    /**
     * 微博指数
     */
    private Integer microBlogIndex;

    /**
     * 百度指数
     */
    private Integer baiDuIndex;

    private Date createTime;

    private Date updateTime;

}
