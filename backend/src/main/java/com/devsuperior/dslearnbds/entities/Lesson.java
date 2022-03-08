package com.devsuperior.dslearnbds.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED) //Como está é uma super classe as suas filhas terão tabelas únicas com essa estratégia
public abstract class Lesson implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //As entidades que são herdeiras receberão o mesmo valor da Lesson
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(
            name = "tb_lesson_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            }
    ) //A classe de associação tem a primary key composta, por isso a necessidade dos três campos na tabela
    private Set<Enrollment> enrollmentsDone;

    @OneToMany(mappedBy = "lesson")
    private Set<Deliver> delivers;

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics = new ArrayList<>();

    public Lesson(){}

    public Lesson(Long id, String title, Integer position, Section section) {
        this.id = id;
        this.title = title;
        this.position = position;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Enrollment> getEnrollmentsDone() {
        return enrollmentsDone;
    }
}
