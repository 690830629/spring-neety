package com.wanglei.business.transactional;

import com.wanglei.business.dao.ProfessionIndexMapper;
import com.wanglei.business.model.ProfessionIndex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MyTransactional implements ITransactional{

    @Autowired
    private ProfessionIndexMapper professionIndexMapper;

    @Transactional
    @Override
    public void get() {
        ProfessionIndex professionIndex=new ProfessionIndex();
        ProfessionIndex professionIndex1=null;
        professionIndex.setBaiDuIndex(1);
        professionIndex.setMaoYanIndex(1);
        professionIndex.setMicroBlogIndex(1);
        professionIndex.setWeChatIndex(1);
        professionIndex.setProjectId(100);
        System.out.println("事物开始");
        int insert = professionIndexMapper.insert(professionIndex);
        professionIndexMapper.insert(professionIndex1);
    }
}
