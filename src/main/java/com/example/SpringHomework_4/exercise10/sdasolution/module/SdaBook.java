package com.example.SpringHomework_4.exercise10.sdasolution.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sda_books")
public class SdaBook {
    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "pages_num")
    private Integer pagesNum;
}
