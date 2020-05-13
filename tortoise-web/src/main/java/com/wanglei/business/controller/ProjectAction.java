package com.wanglei.business.controller;

import com.wanglei.business.placeholder.MyPlaceHolder;
import com.wanglei.business.service.ProjectService;
import com.wanglei.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectAction {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    @Autowired
    private MyPlaceHolder myPlaceHolder;

    @RequestMapping("/project/test")
    public void getProList() {
        List<Integer> projectList = projectService.getProjectList();

        System.out.println(myPlaceHolder.getName());
    }


}
