package com.ipsator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipsator.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
