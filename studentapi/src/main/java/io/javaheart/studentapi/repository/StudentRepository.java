package io.javaheart.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaheart.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
