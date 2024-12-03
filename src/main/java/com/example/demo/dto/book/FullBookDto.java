package com.example.demo.dto.book;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullBookDto {

    String author;

    String title;

    Integer year;

    String publisher;

    Integer price;

    Integer count;

    Integer pageCount;
}
