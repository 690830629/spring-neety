package com.wanglei.business.dao;

import com.wanglei.business.model.ProfessionIndex;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProfessionIndexMapper {


    ProfessionIndex getByProjectIdAndCreateTime(@Param("projectId") int projectId,
                                                @Param("createTime") Date createTime
    );

    List<ProfessionIndex> getBySpec(@Param("projectId") int projectId,
                                    @Param("startTime") Date startTime,
                                    @Param("endTime") Date endTime
    );

    int insert(ProfessionIndex record);

    int updateByProjectIdAndCreateTime(ProfessionIndex record);

}
