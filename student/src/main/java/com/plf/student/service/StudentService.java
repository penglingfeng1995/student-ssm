package com.plf.student.service;

import com.plf.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> selectStudent(Integer start, Integer size);
}
