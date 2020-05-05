package com.wanglei.business.controller;

import com.wanglei.business.model.Student;
import com.wanglei.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentAction  {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent() {
        System.out.println(userService);
        Student student = new Student("王蕾",27);
        student.setAge(27);
        student.setName("王蕾");
        return student;

    }


}
