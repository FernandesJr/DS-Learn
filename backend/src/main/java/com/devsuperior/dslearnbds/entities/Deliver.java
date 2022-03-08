package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.enums.DeliverStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_deliver")
public class Deliver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uri;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //Armazenar na db sem Time zone, permanece o meridiano de greenwich, UTC(Coordinated Universal Time)
    private Instant moment;

    private DeliverStatus status;

    private String feedback;

    private Integer correctCount;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne //Mapeando foreignKey composta
    @JoinColumns({
            @JoinColumn(name = "user_id"),
            @JoinColumn(name = "offer_id")
    })
    private Enrollment enrollment;

    public Deliver(){}

    public Deliver(Long id, String uri, Instant moment, DeliverStatus status, String feedback, Integer correctCount) {
        this.id = id;
        this.uri = uri;
        this.moment = moment;
        this.status = status;
        this.feedback = feedback;
        this.correctCount = correctCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }
}
