package com.springFluxAPI.controller;

import com.springFluxAPI.entities.Book;
import com.springFluxAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Creating
    @PostMapping
    public Mono<Book> create(@RequestBody Book book){

       return bookService.create(book);
    }

    // Get All book
    @GetMapping
    public Flux<Book> getAllBook(){
        return  bookService.getAll();
    }

    // get single book
    @GetMapping("/{bookId}")
    public  Mono<Book> get(@PathVariable int bookId ){
        return  bookService.get(bookId);
    }

    //update
    @PutMapping("/{bookId}")
    public  Mono<Book> update(@RequestBody Book book, @PathVariable int bookId){
        return  bookService.update(book, bookId);
    }

    //delete
    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }

    @GetMapping("/search")
    public  Flux<Book> serachBooks(
            @RequestParam ("query") String query){
        return this.bookService.searchBooks(query);
    }
}
