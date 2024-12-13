package com.phyo.mongodb.controller;

import com.phyo.mongodb.entity.Student;
import com.phyo.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/findById/{id}")
    public Student findStudentById(@PathVariable String id){
        return studentService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/findByNameAndEmail")
    public Student findByNameAndEmail(@RequestParam String name, String email){
        return studentService.findByNameAndEmail(name,email);
    }

    @GetMapping("/findByNameOrEmail")
    public List<Student> findByNameOrEmail(@RequestParam String name, String email){
        return studentService.findByNameOrEmail(name,email);
    }

    @GetMapping("/findByName/{name}")
    public List<Student> getByName(@PathVariable String name){
        return studentService.findByName(name);
    }

    @GetMapping("/findWithPagination")
    public List<Student> findWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.findWithPagination(pageNo, pageSize);
    }

    @GetMapping("/findWithSorting")
    public List<Student> findWithPagination(){
        return studentService.findWithSorting();
    }

    @GetMapping("/findByDepartmentName")
    public List<Student> findByDepartmentName(@RequestParam String name){
        return studentService.findByDepartmentName(name);
    }

    @GetMapping("/findByEmailLike")
    public List<Student> findByEmailLike(@RequestParam String email){
        return studentService.findByEmailLike(email);
    }

    @GetMapping("/findByNameStartWith")
    public List<Student> findByNameStartWith(@RequestParam String name){
        return studentService.findByNameStartWith(name);
    }

    @GetMapping("/findByDepartmentId")
    public List<Student> findByDepartmentId(@RequestParam String departmentId){
        return studentService.findByDepartmentId(departmentId);
    }
}
