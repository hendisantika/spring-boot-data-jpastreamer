package com.hendisantika.controller;

import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final JPAStreamer jpaStreamer;

}
