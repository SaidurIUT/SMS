package com.project.SMS.repository;

import com.project.SMS.entities.Programme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme, Long> {
    // You can define custom queries if necessary, for example:
    // Optional<Programme> findByName(String name);
}
