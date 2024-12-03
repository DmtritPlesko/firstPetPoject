package com.example.demo.service.book;

import com.example.demo.dto.book.ShortBookDto;

import java.util.List;

public interface BookService {

    ShortBookDto getBookById(Long id);

    List<ShortBookDto> getAllBook();
}
