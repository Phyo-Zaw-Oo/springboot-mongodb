package com.phyo.mongodb.repository;

import com.phyo.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository <Student, String> {
     List<Student> findByName(String name);

     Student findByNameAndEmail(String name, String email);

     List<Student> findByNameOrEmail(String name, String email);

     List<Student> findByDepartmentDepartmentName(String name);

     List<Student> findByEmailIsLike(String email);

     List<Student> findByNameStartsWith(String name);

     List<Student> findByDepartmentId(String id);

     @Query ("{\"name\": \"?0\"}")
     List<Student> getByName(String name);
}
