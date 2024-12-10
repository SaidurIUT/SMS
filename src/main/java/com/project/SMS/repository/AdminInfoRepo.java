package com.project.SMS.repository;

import com.project.SMS.entities.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminInfoRepo extends JpaRepository<AdminInfo, Long> {

    /**
     * Finds AdminInfo by user ID.
     *
     * @param userId the ID of the associated User entity
     * @return an Optional containing the AdminInfo if found, otherwise empty
     */
    Optional<AdminInfo> findByUserId(Long userId);

    /**
     * Checks if an AdminInfo exists for the given user ID.
     *
     * @param userId the ID of the associated User entity
     * @return true if an AdminInfo exists, otherwise false
     */
    boolean existsByUserId(Long userId);
}
