package com.padelapp.repository;

import com.padelapp.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
}
