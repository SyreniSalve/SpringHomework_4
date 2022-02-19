package com.example.SpringHomework_4.exercise10.mysolution.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String title;

    private String author;

    @Column(name = "isbn")
    @Length(min = 10, max = 10)
    private String ISBN;

    @Column(name = "pages_number")
    private Integer pagesNum;
}
