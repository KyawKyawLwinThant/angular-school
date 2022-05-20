package com.example.angularschool.ds;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CourseDto {
    private int id;
    private String title;
    private int duration;
    private double price;
    private String imageUrl;
    private String description;

    public CourseDto() {
    }

    public CourseDto(int id, String title, int duration, double price, String imageUrl, String description) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }


}
