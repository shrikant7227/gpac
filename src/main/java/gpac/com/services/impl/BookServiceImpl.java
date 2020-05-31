package gpac.com.services.impl;

import gpac.com.daos.BookRepository;
import gpac.com.daos.LibraryRepository;
import gpac.com.entities.Book;
import gpac.com.entities.Library;
import gpac.com.services.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
@Service
@Transactional
@Slf4j
public class BookServiceImpl implements IBookService {

    private final EntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    LibraryRepository libraryRepository;

    public BookServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByLibraryName(String name) {
        return this.entityManager.createQuery("SELECT b from Book b where b.libraryDept = :name", Book.class).setParameter("name", name).getResultList();
    }

    @Override
    public void save(Book book) throws Exception {
        log.info("Saving Book Entity");
        List<Library> library = this.entityManager.createQuery("SELECT l from Library l where l.name =:name", Library.class).setParameter("name", book.getLibraryDept()).getResultList();
        if (library.size() > 0)
            book.setLibraryDept(library.get(0).getName());
        else
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        bookRepository.saveAndFlush(book);
    }

    @Override
    public void update(int bookId, Book book) {
        log.info("Updating Book: " + bookId);
        Book bookOptional = bookRepository.findById(bookId).orElse(book);
        if (!StringUtils.isEmpty(book.getTitle())) bookOptional.setTitle(book.getTitle());
        if (!StringUtils.isEmpty(book.getPublicationName())) bookOptional.setPublicationName(book.getPublicationName());
        if (!StringUtils.isEmpty(book.getAuthorName())) bookOptional.setAuthorName(book.getAuthorName());
        if (!StringUtils.isEmpty(book.getIsbn())) bookOptional.setIsbn(book.getIsbn());
        if (!StringUtils.isEmpty(book.getLibraryDept())) bookOptional.setLibraryDept(book.getLibraryDept());
        bookRepository.flush();
    }
}
