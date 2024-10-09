package com.springFluxAPI;

import com.springFluxAPI.entities.Book;
import com.springFluxAPI.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepositoryFinderTest {
@Autowired
    private BookRepository bookRepository;

@Test
public  void finderMethodTest(){
//    System.out.println("Finder Method test");

//    Mono<Book> nameMono = bookRepository.findByName("Angular Front end");
//    StepVerifier.create(nameMono)
//            .expectNextCount(1)
//            .verifyComplete();


    Flux<Book> authorFlux = bookRepository.findByAuthor("Auth1");
    StepVerifier.create(authorFlux)
            .expectNextCount(1)
            .verifyComplete();

//    bookRepository.findByNameAndAuthor("book1", "Auth1")
//            .as(StepVerifier::create)
//            .verifyComplete();



    }
    @Test
    public void queryMethodsTest(){
        bookRepository.getAllBookByNameAndAuthor("book1","Auth1")
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();

}

@Test
    public  void  searchByTitleAll(){
    bookRepository.searchByTitle("%Book1%")
            .as(StepVerifier::create)
            .expectNextCount(1)
            .verifyComplete();

}

}
