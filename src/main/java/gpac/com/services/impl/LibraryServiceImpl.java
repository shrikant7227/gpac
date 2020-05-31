package gpac.com.services.impl;

import gpac.com.daos.LibraryRepository;
import gpac.com.entities.Library;
import gpac.com.services.ILibraryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class LibraryServiceImpl implements ILibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public void save(Library library) {
        libraryRepository.saveAndFlush(library);
    }
}
