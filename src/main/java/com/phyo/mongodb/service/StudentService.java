package com.phyo.mongodb.service;

import com.phyo.mongodb.entity.Student;
import com.phyo.mongodb.repository.DepartmentRepository;
import com.phyo.mongodb.repository.StudentRepository;
import com.phyo.mongodb.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student save(Student student){
        if(student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects() != null && student.getSubjects().size() > 0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student findById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id){
        studentRepository.deleteById(id);
        return "Student has been deleted successfully!";
    }

    public  List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public Student findByNameAndEmail(String name, String email){
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> findByNameOrEmail(String name, String email){
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> findWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> findWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }

    public List<Student> findByDepartmentName(String name) {

        return studentRepository.findByDepartmentDepartmentName(name);
    }

    public List<Student> findByEmailLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> findByNameStartWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> findByDepartmentId(String id) {
        return studentRepository.findByDepartmentId(id);
    }

}

