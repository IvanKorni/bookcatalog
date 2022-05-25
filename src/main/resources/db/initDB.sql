drop table if exists books;


create table books
(
    id     int          not null primary key,
    name   VARCHAR(255) not null,
    author VARCHAR(255) not null,
    isbn   VARCHAR(255) not null
);
