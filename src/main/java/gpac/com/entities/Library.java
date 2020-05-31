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
@Table(name = "LIBRARY", schema = "PUBLIC")
public class Library {
    @Id
    @SequenceGenerator(name = "LIBRARY_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "LIBRARY_SEQ")
    @GeneratedValue(generator = "LIBRARY_SEQ")
    @Column(name = "LIBRARY_ID")
    private int libraryId;
    @Column(name = "NAME", unique = true)
    private String name;
    @Column(name = "CITY")
    private String city;
    /*@OneToMany(mappedBy = "libraryByLibraryId")
    private List<Book> booksByLibraryId;*/

    public Library() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        if (libraryId != library.libraryId) return false;
        if (!Objects.equals(name, library.name)) return false;
        return Objects.equals(city, library.city);
    }

    @Override
    public int hashCode() {
        int result = libraryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
