package com.padelapp.repository;


import com.padelapp.entities.Festive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FestiveRepository extends JpaRepository<Festive,Integer> {
}
