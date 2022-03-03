package com.devsuperior.dslearnbds.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_section")
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne //Relacionamento com ela mesma, essa section pode ter outra section como pré-requisito, porém, esta sendo mapeado apenas de forma unidirecional
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    public Section(){}

    public Section(Long id, String title, String description, Integer position, String imgUri) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.position = position;
        this.imgUri = imgUri;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
