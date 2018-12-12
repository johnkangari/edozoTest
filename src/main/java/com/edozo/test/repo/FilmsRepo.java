package com.edozo.test.repo;

import com.edozo.test.domain.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmsRepo extends CrudRepository<Film, Integer> {
    public List<Film> paginatedAll(Pageable pageable);

}
