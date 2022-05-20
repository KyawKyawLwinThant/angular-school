package com.example.angularschool.ds;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
