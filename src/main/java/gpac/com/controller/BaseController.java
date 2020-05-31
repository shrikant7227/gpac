package gpac.com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gpac.com.entities.Book;
import gpac.com.entities.Library;
import gpac.com.services.impl.BookServiceImpl;
import gpac.com.services.impl.LibraryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
@Controller
@Slf4j
@CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
public class BaseController {
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    LibraryServiceImpl libraryService;

    @GetMapping(value = "/book/all", produces = "application/json")
    public ResponseEntity<List<Book>> getBooks() throws JsonProcessingException {
        List<Book> books = bookService.findAll();
        log.info("Books are: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(books));
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "book/library/{dept}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> getLibraryBooks(@PathVariable("dept") String dept) throws JsonProcessingException {
        List<Book> books = bookService.findByLibraryName(dept);
        log.info("Books are: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(books));
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "library/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Library>> getLibraries() throws JsonProcessingException {
        List<Library> libraries = libraryService.findAll();
        log.info("Libraries are: {}", objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(libraries));
        return ResponseEntity.ok(libraries);
    }

    @PostMapping(value = "/book/create", consumes = "application/json")
    public ResponseEntity<String> saveBook(@RequestBody Book book) {
        log.info("Request Body: {}", book);
        try {
            bookService.save(book);
            return ResponseEntity.of(Optional.of(HttpStatus.CREATED.getReasonPhrase()));
        } catch (Exception ex) {
            return ResponseEntity.of(Optional.of("Library Entry: " + ex.getMessage()));
        }

    }

    @PostMapping(value = "/book/update/{id}", consumes = "application/json")
    public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        log.info("Request Body: {} and id: {}", book, id);
        try {
            bookService.update(id, book);
            return ResponseEntity.of(Optional.of(HttpStatus.CREATED.getReasonPhrase()));
        } catch (Exception ex) {
            return ResponseEntity.of(Optional.of("Library Entry: " + ex.getMessage()));
        }

    }

    @PostMapping(value = "/library/create", consumes = "application/json")
    public ResponseEntity<String> saveLibrary(@RequestBody Library library) {
        log.info("Request Body: {}", library);
        try {
            libraryService.save(library);
            return ResponseEntity.of(Optional.of(HttpStatus.CREATED.getReasonPhrase()));
        } catch (Exception ex) {
            return ResponseEntity.of(Optional.of(ex.getMessage()));
        }

    }
}
