package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Restaurent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurentRepository extends CrudRepository<Restaurent, Integer> {
    @Query(value = "SELECT res FROM Restaurent res where res.restaurent_name =?1")
    List<Restaurent> findByName(String name);
}
