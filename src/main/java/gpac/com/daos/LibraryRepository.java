package gpac.com.daos;

import gpac.com.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
