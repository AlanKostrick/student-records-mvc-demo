package com.wcci.student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    Map<Long, Student> studentList = new HashMap<>();

    private Student studentOne = new Student(1L, "Cliff Jenkins", "https://github.com/cljenkinsjr");
    private Student studentTwo = new Student(2L, "Jordan Gilpin", "https://github.com/codefox96");
    private Student studentThree = new Student(3L, "Alan Kostrick", "https://github.com/AlanKostrick");

    public StudentRepository() {
        studentList.put(studentOne.getId(), studentOne);
        studentList.put(studentTwo.getId(), studentTwo);
        studentList.put(studentThree.getId(), studentThree);
    }

    public Student findOne(long id) {
        return studentList.get(id);
    }

    public Collection<Student> findAll() {
        return studentList.values();
    }

}
