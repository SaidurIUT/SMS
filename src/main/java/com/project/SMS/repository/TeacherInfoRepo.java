package com.project.SMS.repository;

import com.project.SMS.entities.TeacherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherInfoRepo extends JpaRepository<TeacherInfo, Long> {

    /**
     * Finds TeacherInfo by user ID.
     *
     * @param userId the ID of the associated User entity
     * @return an Optional containing the TeacherInfo if found, otherwise empty
     */
    Optional<TeacherInfo> findByUserId(Long userId);

    /**
     * Finds all TeacherInfo entities belonging to a specific department.
     *
     * @param departmentId the ID of the Department entity
     * @return a List of TeacherInfo entities in the specified department
     */
    List<TeacherInfo> findAllByDepartmentId(Long departmentId);

    /**
     * Checks if a TeacherInfo exists for the given user ID.
     *
     * @param userId the ID of the associated User entity
     * @return true if a TeacherInfo exists, otherwise false
     */
    boolean existsByUserId(Long userId);
}
