package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "Books")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "author")
    String author;

    @Column(name = "title")
    String title;

    @Column(name = "year")
    Integer year;

    @Column(name = "publisher")
    String publisher;

    @Column(name = "price")
    Integer price;

    @Column(name = "count")
    Integer count;

    @Column(name = "page_count")
    Integer pageCount;

}
