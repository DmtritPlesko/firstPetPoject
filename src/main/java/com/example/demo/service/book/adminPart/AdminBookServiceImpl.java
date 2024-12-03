package com.example.demo.service.book.adminPart;

import com.example.demo.dto.book.FullBookDto;
import com.example.demo.dto.book.ShortBookDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.book.publicPart.PublicBookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminBookServiceImpl implements AdminBookService {

    final PublicBookService publicBookService;
    final BookRepository repository;
    final BookMapper mapper;

    @Override
    public ShortBookDto addBook(FullBookDto book, Long id) {

        Book book1 = mapper.toBook(book);
        book1.setId(id);

        return mapper.toShortBookDto(repository.save(book1));
    }

    @Override
    public ShortBookDto updateBook(FullBookDto book, Long id) {
        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();

            if (book.getAuthor() != null) {
                existingBook.setAuthor(book.getAuthor());
            }
            if (book.getCount() != null) {
                existingBook.setCount(book.getCount());
            }
            if (book.getPrice() != null) {
                existingBook.setPrice(book.getPrice());
            }
            if (book.getYear() != null) {
                existingBook.setYear(book.getYear());
            }
            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }
            if (book.getPageCount() != null) {
                existingBook.setPageCount(book.getPageCount());
            }

            repository.save(existingBook);

            return mapper.toShortBookDto(existingBook);
        } else {
            throw new EntityNotFoundException("Книга с ID " + id + " не найдена.");
        }
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ShortBookDto getBookById(Long id) {
        return publicBookService.getBookById(id);
    }

    @Override
    public List<ShortBookDto> getAllBook() {
        return publicBookService.getAllBook();
    }
}
