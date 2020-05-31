DROP TABLE IF EXISTS BOOK;

DROP TABLE IF EXISTS LIBRARY;

DROP SEQUENCE IF EXISTS book_seq;

DROP SEQUENCE IF EXISTS library_seq;

create table LIBRARY
(
    library_id number(10, 0) NOT NULL AUTO_INCREMENT,
    name       varchar(255)  not null unique,
    city       varchar(255)  not null,
    PRIMARY KEY (library_id)
);

create table BOOK
(
    book_id          number(10, 0) not null AUTO_INCREMENT,
    publication_name varchar(255)  not null,
    title            varchar(255)  not null,
    author_name      varchar(255)  not null,
    ISBN             varchar(255)  not null unique,
    library_dept     varchar(255) not null,
    PRIMARY KEY (book_id)
);


CREATE SEQUENCE book_seq
    MINVALUE 1
    MAXVALUE 9999999999999999
    START WITH 1
    INCREMENT BY 1
    CACHE 100;

CREATE SEQUENCE library_seq
    MINVALUE 1
    MAXVALUE 9999999999999999
    START WITH 1
    INCREMENT BY 1
    CACHE 100;
