package com.arma.springbootMyGoalsarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.springbootMyGoalsarma.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>{

}