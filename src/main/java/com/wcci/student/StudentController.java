package com.wcci.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Resource
    private StudentRepository studentRepo;

    @RequestMapping("/")
    public String homePage(){
        return "home.html";
    }

    @RequestMapping("/students")
    public String findAllStudents(Model model) {
        model.addAttribute("studentsModel", studentRepo.findAll());
        return "studentsTemplate";
    }

    @RequestMapping("/students/{id}")
    public String findOneStudent(@PathVariable Long id, Model model) throws StudentNotFoundException {

        if (studentRepo.findOne(id) == null) {
            throw new StudentNotFoundException();
        }
        model.addAttribute("studentModel", studentRepo.findOne(id));
        return "studentTemplate";
    }

}
