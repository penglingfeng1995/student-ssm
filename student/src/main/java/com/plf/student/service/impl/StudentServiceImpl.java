package com.plf.student.service.impl;

import com.plf.student.mapper.StudentMapper;
import com.plf.student.model.Student;
import com.plf.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectStudent(Integer start, Integer size) {
        return studentMapper.selectStudent(start,size);
    }

    @Override
    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Integer selectCount() {
        return studentMapper.selectCount();
    }
}
