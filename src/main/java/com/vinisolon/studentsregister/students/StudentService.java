package com.vinisolon.studentsregister.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Student findByEmail(@RequestParam String email) {
        return studentRepository.findByEmail(email);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
