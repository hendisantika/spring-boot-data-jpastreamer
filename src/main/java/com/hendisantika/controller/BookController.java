package com.hendisantika.controller;

import com.hendisantika.entity.Book;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
