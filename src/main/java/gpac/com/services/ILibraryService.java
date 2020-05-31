package gpac.com.services;

import gpac.com.entities.Library;

import java.util.List;

/*
*   
    Created By: shrkumar1
    Date: {Date}
    Project Name: gpac
*
*/
public interface ILibraryService {
    List<Library> findAll();
    void save(Library library);
}
