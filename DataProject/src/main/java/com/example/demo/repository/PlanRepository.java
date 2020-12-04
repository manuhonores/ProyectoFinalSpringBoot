package com.example.demo.repository;

import com.example.demo.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan,Long>{
    @Query("SELECT p FROM Plan p WHERE p.travel.id = :id")
    public List<Plan> getPlanByTravelId(long id);
}
