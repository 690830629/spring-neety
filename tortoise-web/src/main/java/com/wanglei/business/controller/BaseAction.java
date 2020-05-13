package com.wanglei.business.controller;

import com.wanglei.business.model.Student;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseAction {

    @ModelAttribute
    public void getBasicInfo(Model params) {
        Student student = new Student();
        student.setName("程芳");
        student.setAge(28);
        params.addAttribute("student",student);

    }


}
