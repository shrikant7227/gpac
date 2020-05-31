package gpac.com.daos;

import gpac.com.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
