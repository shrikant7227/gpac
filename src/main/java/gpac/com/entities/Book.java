package gpac.com.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Objects;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
@Slf4j
@Getter
@Setter
@Entity
@Table(name = "BOOK", schema = "PUBLIC")
public class Book {
    @Id
    @SequenceGenerator(name = "BOOK_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "BOOK_SEQ")
    @GeneratedValue(generator = "BOOK_SEQ")
    @Column(name = "BOOK_ID")
    private int bookId;
    @Column(name = "PUBLICATION_NAME")
    private String publicationName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "ISBN", unique = true)
    private String isbn;
    /*@Lazy
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID", nullable = false)
    private Library libraryByLibraryId;*/
    @Column(name = "library_dept")
    private String libraryDept;

    public Book() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if (bookId != book.bookId) return false;
        if (!Objects.equals(publicationName, book.publicationName)) return false;
        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(authorName, book.authorName)) return false;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (publicationName != null ? publicationName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }
}
