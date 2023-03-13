package com.hendisantika;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-data-jpastreamer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/13/23
 * Time: 09:09
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity(name = "author")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    @Column(unique = true)
    private String lastName;

    @OneToMany
    private List<Book> books;
}
