package com.example.demo.repository;

import com.example.demo.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("SELECT t FROM Travel t WHERE t.id = :id")
    public Travel getId (Long id);

    @Query("SELECT t FROM Travel t WHERE t.user.id = :id")
    public List<Travel> getTravelUserId(Long id);

}
