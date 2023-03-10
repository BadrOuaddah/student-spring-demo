package com.example.demo.student;

import com.example.demo.exception.ApiRequestException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.representer.BaseRepresenter;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    List<Student> list = new ArrayList<>();
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw  new IllegalStateException("student with id : "+ studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(long studentId, Student student){
        Optional<Student> studentOptional = studentRepository.findStudentById(studentId);
        if (studentOptional.isPresent()) {
            Student s = studentOptional.get();
            s.setName(student.getName());
            s.setDob(student.getDob());
            s.setEmail(student.getEmail());
            studentRepository.save(s);
        }
        if (studentOptional.isEmpty()){
            //TODO: Add status is 400 when no student exist when an id
            throw new ApiRequestException();
        }
    }


}
