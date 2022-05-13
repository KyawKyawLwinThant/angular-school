package com.example.angularschool.ds;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Course extends IdClass{

    private String title;
    private int duration;
    private double price;
    private String imageUrl;
    private String description;

    @ManyToOne
    private Category category;

}
