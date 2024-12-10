package com.project.SMS.repository;

import com.project.SMS.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentInfoRepo extends JpaRepository<StudentInfo, Long> {

    /**
     * Finds StudentInfo by user ID.
     *
     * @param userId the ID of the associated User entity
     * @return an Optional containing the StudentInfo if found, otherwise empty
     */
    Optional<StudentInfo> findByUserId(Long userId);

    /**
     * Finds all StudentInfo entities by grade.
     *
     * @param grade the grade of the students
     * @return a List of StudentInfo entities in the specified grade
     */
    List<StudentInfo> findAllByGrade(String grade);

    /**
     * Checks if a StudentInfo exists for the given user ID.
     *
     * @param userId the ID of the associated User entity
     * @return true if a StudentInfo exists, otherwise false
     */
    boolean existsByUserId(Long userId);
}
