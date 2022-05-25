package com.library.springboot.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String ISBN;

}
