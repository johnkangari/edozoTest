package com.edozo.test.controller;

import com.edozo.test.domain.Film;
import com.edozo.test.domain.Rental;
import com.edozo.test.exceptions.NotAcceptableEx;
import com.edozo.test.exceptions.NotFoundEx;
import com.edozo.test.repo.FilmsRepo;
import com.edozo.test.repo.RentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.edozo.test.services.SQLServer.getSQL;

@RestController
@CrossOrigin
@RequestMapping("")
public class controller {

    /**
     * Movies repository
     */
    private final FilmsRepo filmsRepo;
    private final RentalRepo rentalRepo;

    @Autowired
    public controller(FilmsRepo filmsRepo, UserDetailsService userDetailsService, RentalRepo rentalRepo) {
        this.filmsRepo = filmsRepo;
        this.rentalRepo = rentalRepo;
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

    /**
     * List of rentals
     *
     * @param start start of list
     * @param limit limit end of list
     * @return Rentals
     * @throws ClassNotFoundException SQLConnection exception
     */
    @GetMapping(value = "/rentals", produces = "application/json")
    public String getRentals(@PathParam("start") final int start, @PathParam("limit") final int limit) throws ClassNotFoundException {
        try {
            return getSQL("SELECT f.title, c.city, c.name, r.return_date \n" +
                    "FROM (((public.rental r \n" +
                    "     JOIN public.customer_list c ON ((r.customer_id = c.id)))\n" +
                    "     JOIN public.inventory i ON ((r.inventory_id = i.inventory_id)))\n" +
                    "     JOIN public.film f ON ((i.film_id = f.id)))\n" +
                    "     ORDER BY (r.rental_date) DESC\n" +
                    "     OFFSET " + start + " LIMIT " + limit + ";").toString();
        } catch (SQLException e) {
            throw new NotAcceptableEx("There is an error on database statement");
        }
    }

    /**
     * List of overdue rentals
     *
     * @param pageNo Integer page number
     * @param size   Integer size of records in a page
     * @return list of rentals
     */
    @GetMapping(value = "/rental/overdue", produces = "application/json")
    public List<Rental> getOverdueRentals(@PathParam("no") final int pageNo, @PathParam("size") final int size) {
        return rentalRepo.findByReturnDateAfterByPage(new Date(), PageRequest.of(pageNo, size));
    }

    /**
     * Calculate customer overdue
     *
     * @param id customer
     * @return balance
     */
    @GetMapping(name = "/rental/user/{id}/overdue", produces = "application/json")
    public String totalAmountOfOverdue(@PathVariable("id") final int id) {
        try {
            return getSQL("public.get_customer_balance(" + id + ", " + new Date() + ")").toString();
        } catch (SQLException e) {
            throw new NotAcceptableEx("There is an error on database statement");
        }
    }
}