package com.vinisolon.studentsregister.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/crud/")
public class StudentResource {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(studentService.findById(id));
    }

    @GetMapping(value = "/students/email")
    public ResponseEntity<Student> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok().body(studentService.findByEmail(email));
    }

    @PostMapping(value = "/students/create")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
        return ResponseEntity.created(uri).body(studentService.save(student));
    }

    @PutMapping(value = "/students/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.save(student));
    }

    @DeleteMapping(value = "/students/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
