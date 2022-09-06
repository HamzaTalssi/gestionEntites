package com.htalssi.gestionemployes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htalssi.gestionemployes.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	void deleteStudentById(Long id);

	Optional<Student> findStudentById(Long id);
}
