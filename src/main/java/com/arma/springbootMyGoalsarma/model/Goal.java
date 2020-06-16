package com.arma.springbootMyGoalsarma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "goals")
public class Goal {
    private long id;
    private String goal;
    private String descrip;
    private Date start_date;
    private Date end_date;
    private boolean complete;
    private boolean critic;
    private int category;
    private int progress;
    private String hazard;

    public Goal() {

    }

    public Goal(String goal, String descrip, Date start_date, Date end_date, boolean complete, boolean critic,
            int category, int progress, String hazard) {
        this.goal = goal;
        this.descrip = descrip;
        this.start_date = start_date;
        this.end_date = end_date;
        this.complete = complete;
        this.critic = critic;
        this.category = category;
        this.progress = progress;
        this.hazard = hazard;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "goal", nullable = true)
    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @Column(name = "descrip", nullable = true)
    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Column(name = "start_date", nullable = false)
    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    @Column(name = "end_date", nullable = false)
    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Column(name = "complete", nullable = false)
    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Column(name = "critic", nullable = false)
    public boolean getCritic() {
        return critic;
    }

    public void setCritic(boolean critic) {
        this.critic = critic;
    }

    @Column(name = "category", nullable = false)
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Column(name = "progress", nullable = false)
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Column(name = "hazard", nullable = false)
    public String getHazard() {
        return hazard;
    }

    public void setHazard(String hazard) {
        this.hazard = hazard;
    }

}