package com.hendisantika.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-data-jpastreamer
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 3/13/23
 * Time: 09:10
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Entity(name = "book")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
