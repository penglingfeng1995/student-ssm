package com.plf.student.mapper;

import com.plf.student.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    List<Student> selectStudent(@Param("start") Integer start,@Param("size") Integer size);

    Integer addStudent(@Param("student") Student student);

    Integer selectCount();
}
