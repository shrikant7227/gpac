package gpac.com;
/*
 * Here we consider that book with any associated library doesn't exist but vice versa should be
 *
 * */

import com.fasterxml.jackson.databind.ObjectMapper;
import gpac.com.entities.Book;
import gpac.com.entities.Library;
import gpac.com.services.impl.BookServiceImpl;
import gpac.com.services.impl.LibraryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class GpacApplicationTests {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    LibraryServiceImpl libraryService;

    @Test
    void contextLoads() {
    }

    @Test
    public void createLibrary() {
        String libData = "{\n" +
                "  \"name\" : \"IT\",\n" +
                "  \"city\" : \"Delhi\"\n" +
                "}";
        try {
            libraryService.save(objectMapper.readValue(libData, Library.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Let We are creating book for a library which is exists LIKE:  IT
     * */
    @Test
    public void createBook() {
        String booData = "{\n" +
                "  \"publicationName\" : \"Shrikant-Pub\",\n" +
                "  \"title\" : \"Computer\",\n" +
                "  \"authorName\" : \"Shrikant Kumar\",\n" +
                "  \"isbn\" : 102,\n" +
                "  \"libraryDept\" : \"IT\"\n" +
                "}";
        try {
            bookService.save(objectMapper.readValue(booData, Book.class));
        } catch (Exception ex) {
            log.error("Book Creation Failed: {}", ex.getMessage());
        }
    }

    /*
     * Let We are creating book for a library which is not exists
     * */
    @Test
    public void createBookWithoutExistingLibrary() {
        String booData = "{\n" +
                "  \"publicationName\" : \"Shrikant-Pub\",\n" +
                "  \"title\" : \"Science\",\n" +
                "  \"authorName\" : \"Shrikant Kumar\",\n" +
                "  \"isbn\" : 103,\n" +
                "  \"libraryDept\" : \"SCIENCE\"\n" +
                "}";
        try {
            bookService.save(objectMapper.readValue(booData, Book.class));
        } catch (Exception ex) {
            log.error("Book Without Existing Library Creation Failed: {}", ex.getMessage());
        }
    }

    @Test
    public void createBookWithoutLibrary() {
        String bookData = "{\n" +
                "  \"publicationName\" : \"Shrikant-Pub\",\n" +
                "  \"title\" : \"Science\",\n" +
                "  \"authorName\" : \"Shrikant Kumar\",\n" +
                "  \"isbn\" : 104,\n" +
                "}";
        try {
            bookService.save(objectMapper.readValue(bookData, Book.class));
        } catch (Exception ex) {
            log.error("Book Without Library Creation Failed: {}", ex.getMessage());
        }
    }

    @Test
    public void updateBook() {
        String bookData = "{\n" +
                "  \"publicationName\" : \"science-Pub\",\n" +
                "  \"title\" : \"Science\",\n" +
                "  \"authorName\" : \"Shrikant Kumar\",\n" +
                "}";
        try {
            bookService.update(1, objectMapper.readValue(bookData, Book.class));
        } catch (Exception ex) {
            log.error("Book Without Library Creation Failed: {}", ex.getMessage());
        }
    }
}
