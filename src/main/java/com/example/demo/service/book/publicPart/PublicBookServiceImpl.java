package com.example.demo.service.book.publicPart;

import com.example.demo.dto.book.ShortBookDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PublicBookServiceImpl implements PublicBookService {

    final BookRepository repository;
    final BookMapper mapper;

    @Override
    public ShortBookDto getBookById(Long id) {
        Optional<Book> book = repository.findById(id);
        return mapper.toShortBookDto(book.get());
    }

    @Override
    public List<ShortBookDto> getAllBook() {
        return repository.findAll().stream()
                .map(mapper::toShortBookDto)
                .toList();
    }
}
