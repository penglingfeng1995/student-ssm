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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping("selectStudent")
    public Result selectStudent(@RequestParam(defaultValue = "0", required = false) Integer start, @RequestParam(defaultValue = "5", required = false) Integer size) {
        List<Student> students = studentService.selectStudent(start, size);
        Integer count = studentService.selectCount();
        log.info("select student,start:"+start+",size:"+size+",count:"+count);
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        map.put("students",students);
        map.put("count",count);
        result.setData(map);
        result.setMsg("select student success");
        result.setStatus(CommonConstant.SUCCESS);
        return result;
    }

    @ResponseBody
    @RequestMapping("addStudent")
    public Result addStudent(Student student) {
        Integer count = studentService.addStudent(student);
        Result result = new Result();
        result.setData(count);
        if (count != 0) {
            result.setMsg("add student success");
            result.setStatus(CommonConstant.SUCCESS);
        } else {
            result.setMsg("add student fail");
            result.setStatus(CommonConstant.FAIL);
        }
        return result;
    }
}
