package com.arma.springbootMyGoalsarma.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.arma.springbootMyGoalsarma.exception.ResourceNotFoundException;
import com.arma.springbootMyGoalsarma.model.Goal;
import com.arma.springbootMyGoalsarma.repository.GoalRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class GoalController {
    @Autowired
    private GoalRepository goalRepository;

    @GetMapping("/goals")
    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    @GetMapping("/goals/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found for this id :: " + id));
        return ResponseEntity.ok().body(goal);
    }

    @PostMapping("/goals")
    public Goal createGoal(@Valid @RequestBody Goal goal) {
        return goalRepository.save(goal);
    }

    @PutMapping("/goals/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable(value = "id") Long id, @Valid @RequestBody Goal goalDetails)
            throws ResourceNotFoundException {
        Goal goal = goalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found for this id :: " + id));

        goal.setGoal(goalDetails.getGoal());
        goal.setDescrip(goalDetails.getDescrip());
        goal.setStart_date(goalDetails.getStart_date());
        goal.setEnd_date(goalDetails.getEnd_date());
        goal.setComplete(goalDetails.getComplete());
        goal.setCritic(goalDetails.getCritic());
        goal.setCategory(goalDetails.getCategory());
        goal.setProgress(goalDetails.getProgress());
        goal.setHazard(goalDetails.getHazard());
        final Goal updatedGoal = goalRepository.save(goal);
        return ResponseEntity.ok(updatedGoal);
    }
}
