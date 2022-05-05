package com.vinisolon.studentsregister.students;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinisolon.studentsregister.students.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student implements Serializable {
    private static final long serialVersionUID = 6341725504908093691L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private String email;
    private Integer gender;

    public Student(Long id, String name, LocalDate birthDate, String email, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        setGender(gender);
    }

    public Gender getGender() {
        return Gender.valueOfCode(this.gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender.getCode();
    }
}
