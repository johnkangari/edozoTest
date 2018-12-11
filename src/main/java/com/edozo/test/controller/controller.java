package com.edozo.test.controller;

import com.edozo.test.domain.Film;
import com.edozo.test.exceptions.NotFoundEx;
import com.edozo.test.repo.FilmsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("")
public class controller {

    /**
     * Movies repository
     */
    private final FilmsRepo filmsRepo;

    @Autowired
    public controller(FilmsRepo filmsRepo, UserDetailsService userDetailsService) {
        this.filmsRepo = filmsRepo;
        UserDetailsService userDetailsService1 = userDetailsService;
    }

    /**
     * Authentication Method
     *
     * @param authentication authentication credentials
     * @return
     */
    @GetMapping("/auth")
    public String auth(Authentication authentication) {
        return "In memory authentication";
    }

    /**
     * Get movie by it's ID
     *
     * @param id Integer movie ID
     * @return Film
     */
    @GetMapping("/movie/{id}")
    public Film getMovieById(@PathVariable("id") final int id) {
        Optional<Film> movie = filmsRepo.findById(id);

        // If movie not found give an exception
        if (!movie.isPresent()) {
            throw new NotFoundEx("Movie by given ID not found!");
        }

        return movie.get();
    }

    /**
     * List of movies
     *
     * @param pageNo Integer page number
     * @param size   Integer size of records in a page
     * @return List of movies
     */
    @GetMapping("/movies")
    public List<Film> getMovies(@PathParam("no") final int pageNo, @PathParam("size") final int size) {
        return filmsRepo.paginatedAll(PageRequest.of(pageNo, size));
    }

}
