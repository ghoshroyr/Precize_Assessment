package com.rg.precizeassessment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rg.precizeassessment.entities.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,String>{

}
