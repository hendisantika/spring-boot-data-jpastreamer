package com.hendisantika.controller;

import com.hendisantika.entity.Book;
import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.projection.Projection;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-data-jpastreamer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/13/23
 * Time: 09:11
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping("/api/books")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final JPAStreamer jpaStreamer;

    @GetMapping
    public ResponseEntity<?> findAllBooks() {
        return ResponseEntity.ok(
                jpaStreamer.stream(Book.class)
                        .sorted(Book$.id.reversed())
                        .collect(Collectors.toList()));
    }

    @GetMapping("/ids")
    public ResponseEntity<?> findBookIds() {
        final LongStream ids = jpaStreamer.stream(Book.class)
                .mapToLong(Book$.id.asLong());
        return ResponseEntity.ok(ids);
    }

    @GetMapping("/books/{title}")
    public ResponseEntity<?> findBookByTitle(@PathVariable String title) {
        return ResponseEntity.ok(
                jpaStreamer.stream(Book.class)
                        .filter(Book$.title.contains(title))
                        .collect(Collectors.toList()));
    }

    @GetMapping("/books/sc/{title}")
    public ResponseEntity<?> findBookByTitleUsingStreamConfig(@PathVariable String title) {
        StreamConfiguration<Book> sc = StreamConfiguration
                .of(Book.class)
                .selecting(Projection.select(Book$.id, Book$.title));
        return ResponseEntity.ok(
                jpaStreamer.stream(sc)
                        .filter(Book$.id.greaterThan(2L))
                        .collect(Collectors.toList()));
    }

    @GetMapping("/author/{authorLastName}")
    public ResponseEntity<?> findBookByAuthorLastName(@PathVariable String authorLastName) {
        return ResponseEntity.ok(jpaStreamer.stream(Book.class)
                .filter(k -> k.getAuthor().getLastName().contains(authorLastName))
                .collect(Collectors.toList()));
    }
}
