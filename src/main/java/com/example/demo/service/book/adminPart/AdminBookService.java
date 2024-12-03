package com.example.demo.service.book.adminPart;

import com.example.demo.dto.book.FullBookDto;
import com.example.demo.dto.book.ShortBookDto;
import com.example.demo.service.book.BookService;

public interface AdminBookService extends BookService {

    ShortBookDto addBook(FullBookDto book, Long id);

    ShortBookDto updateBook(FullBookDto book, Long id);

    void deleteBook(Long id);
}
