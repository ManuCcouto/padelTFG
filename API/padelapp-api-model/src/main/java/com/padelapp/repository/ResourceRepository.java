package com.padelapp.repository;



import com.padelapp.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Integer> {

    @Query("SELECT r FROM Resource r WHERE NOT EXISTS ("
            + "SELECT b FROM Booking b "
            + "WHERE b.resource = r "
            + "AND b.startTime >= :startDateTime AND b.startTime < :endDateTime "
            + "OR b.endTime > :startDateTime AND b.endTime <= :endDateTime "
            + ")"
    )
    List<Resource> findAvailableResourcesByTimeSlot(LocalDateTime startDateTime, LocalDateTime endDateTime);

    Optional<Resource> findById(Integer id);

    }
