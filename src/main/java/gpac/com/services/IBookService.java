package gpac.com.services;

import gpac.com.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
public interface IBookService {
    List<Book> findAll();
    List<Book> findByLibraryName(String name);
    void save(Book book) throws Exception;
    void update(int bookId, Book book);
}
