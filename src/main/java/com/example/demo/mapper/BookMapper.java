package com.example.demo.mapper;

import com.example.demo.dto.book.FullBookDto;
import com.example.demo.dto.book.ShortBookDto;
import com.example.demo.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    FullBookDto toFullBookDto(Book book);

    ShortBookDto toShortBookDto(Book book);

    Book toBook(FullBookDto fullBookDto);

    Book toBook(ShortBookDto shortBookDto);
}
