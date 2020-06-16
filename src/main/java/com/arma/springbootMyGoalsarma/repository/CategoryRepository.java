package com.arma.springbootMyGoalsarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.springbootMyGoalsarma.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}