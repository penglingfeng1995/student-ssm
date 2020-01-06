package com.plf.student.controller;

import com.plf.student.constant.CommonConstant;
import com.plf.student.model.Result;
import com.plf.student.model.Student;
import com.plf.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("selectStudent")
    public Result selectStudent(@RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(defaultValue = "10", required = false) Integer size) {
        List<Student> students = studentService.selectStudent(start, size);
        Result result = new Result();
        result.setData(students);
        result.setMsg("select student success");
        result.setStatus(CommonConstant.SUCCESS);
        return result;
    }
}
