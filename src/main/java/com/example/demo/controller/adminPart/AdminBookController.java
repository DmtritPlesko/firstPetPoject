package com.example.demo.controller.adminPart;

import com.example.demo.dto.book.FullBookDto;
import com.example.demo.dto.book.ShortBookDto;
import com.example.demo.service.book.adminPart.AdminBookService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin/book")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminBookController {

    final AdminBookService service;

    @PostMapping("/{id}")
    public ShortBookDto addBook (@RequestBody FullBookDto fullBookDto,
                                 @PathVariable("id") Long id){
        return service.addBook(fullBookDto, id);
    }

    @PutMapping(path = "/{id}")
    public ShortBookDto fullUpdateBook(@RequestBody FullBookDto fullBookDto,
                                   @PathVariable("id") Long id) {
        return service.updateBook(fullBookDto, id);
    }

    @PatchMapping(path = "/{id}")
    public ShortBookDto partUpdateBook(@RequestBody FullBookDto fullBookDto,
                                   @PathVariable("id") Long id) {
        return service.updateBook(fullBookDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable("id") Long id) {
        service.deleteBook(id);
    }

    @GetMapping("/{id}")
    public ShortBookDto getById(@PathVariable("id") Long id) {
        return service.getBookById(id);
    }
}
