package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.exception.RestaurentAlreadyException;
import com.stackroute.userservice.exception.RestaurentNotFoundException;
import com.stackroute.userservice.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class RestaurentController {
    private RestaurentService restaurentService;

    @Autowired
    public RestaurentController(RestaurentService restaurentService) {

        this.restaurentService = restaurentService;
    }

    //this method will add new restaurent
    @PostMapping("/restaurent")
    public ResponseEntity<?> saveRestaurents(@RequestBody Restaurent restaurent) {
        ResponseEntity responseEntity;
        try {
            restaurentService.saveRest(restaurent);
            responseEntity = new ResponseEntity<String>("succefullly created", HttpStatus.CREATED);
        } catch (RestaurentAlreadyException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            ex.printStackTrace();
        }

        return responseEntity;
    }

    // this method will get all restaurents
    @GetMapping("restaurents")
    public List<Restaurent> getALlRestaurents() {
        List<Restaurent> list = restaurentService.getALLRest();
        return list;
    }

    //this method will delete restaurent by id
    @DeleteMapping("/restaurent/{id}")
    public ResponseEntity<String> deleteRestaurent(@PathVariable int id) {
        restaurentService.deleteById(id);
        return new ResponseEntity<String>("Delete succesfully", HttpStatus.OK);
    }

    //this method will update restaurent by id
    @PutMapping("/restaurent/{id}")
    public ResponseEntity<String> updateRestaurent(@RequestBody Restaurent restaurent, @PathVariable int id) throws RestaurentAlreadyException {
        restaurent.setId(id);
        restaurentService.updateRestaurent(restaurent);
        return new ResponseEntity<String>("Update succesfully", HttpStatus.OK);
    }

    //this method will search restaurent by its name
    @GetMapping("restaurent/{name}")
    public ResponseEntity<?> searchRestaurents(@PathVariable String name) {
        try {
            List<Restaurent> saved = restaurentService.findRest(name);
            return new ResponseEntity<List<Restaurent>>(saved, HttpStatus.OK);

        } catch (RestaurentNotFoundException ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

    }

}
