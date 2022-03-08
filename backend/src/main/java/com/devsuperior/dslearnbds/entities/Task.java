package com.devsuperior.dslearnbds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson implements Serializable {

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Armazenar na db sem Time zone, permanece o meridiano de greenwich, UTC(Coordinated Universal Time)
    private Instant dueDate;

    public Task(){}

    public Task(Long id, String title, Integer position, Section section, String description, Integer questionsCount, Integer approvalCount, Double weight, Instant dueDate) {
        super(id, title, position, section); //Herança
        this.description = description;
        this.questionCount = questionsCount;
        this.approvalCount = approvalCount;
        this.weight = weight;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuestionsCount() {
        return questionCount;
    }

    public void setQuestionsCount(Integer questionsCount) {
        this.questionCount = questionsCount;
    }

    public Integer getApprovalCount() {
        return approvalCount;
    }

    public void setApprovalCount(Integer approvalCount) {
        this.approvalCount = approvalCount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }
}
