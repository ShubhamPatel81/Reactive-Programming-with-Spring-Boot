package com.springFluxAPI.repositories;

import com.springFluxAPI.entities.Book;
import io.r2dbc.spi.Parameter;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {


public  Mono<Book> findByName(String name);

 public  Flux<Book> findByAuthor( String author);
 Flux<Book> findByPublisher(String publisher);

 Flux<Book> findByNameAndAuthor(String name, String author);

 @Query("select * from book_details where name = :name and author = :auth")
 Flux<Book> getAllBookByNameAndAuthor(String  name, @Param("auth") String author);

 @Query("select * from book_details where name  LIKE :title")
Flux<Book> searchByTitle(String title);
}
