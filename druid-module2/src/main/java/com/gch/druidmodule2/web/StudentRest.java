package com.gch.druidmodule2.web;

import com.gch.druidmodule2.entity.Student;
import com.gch.druidmodule2.mapper.StudentMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRest {

    @Resource
    StudentMapper studentMapper;

    @GetMapping("list")
    public String list(){
        List<Student> students = studentMapper.selectList(null);
        return students.toString();
    }
}
