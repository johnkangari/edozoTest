package com.edozo.test.repo;

import com.edozo.test.domain.Rental;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RentalRepo extends CrudRepository<Rental, Integer> {
    public List<Rental> paginatedAll(Pageable pageable);
    public List<Rental> findByReturnDateAfterByPage(Date now, Pageable pageable);
    public List<Rental> findByReturnDateAfterAndCustomerId(Date now, int customerId);
}
