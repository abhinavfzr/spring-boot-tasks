package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.exception.RestaurentAlreadyException;
import com.stackroute.userservice.exception.RestaurentNotFoundException;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurentService
{
    private RestaurentRepository restaurentRepository;

    @Autowired
    public RestaurentService(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    public Restaurent saveRest(Restaurent restaurent) throws RestaurentAlreadyException
    {
        if(restaurentRepository.existsById(restaurent.getId()))
        {
            throw new RestaurentAlreadyException("restaurent already exist");
        }
      Restaurent restaurent1= restaurentRepository.save(restaurent);
        if(restaurent1==null)
        {
            throw  new RestaurentAlreadyException("restaurent already exist");
        }
      return restaurent1;
    }
    public List<Restaurent> getALLRest(){
     return (List<Restaurent>)restaurentRepository.findAll();

    }
    public List<Restaurent> findRest(String name) throws RestaurentNotFoundException {
        List<Restaurent> restaurent=restaurentRepository.findByName(name);
        if (restaurent.isEmpty())
        {
            throw new RestaurentNotFoundException("restaurent not found");
        }
        return  restaurent;
    }

    public Restaurent deleteById(int id) {
        restaurentRepository.deleteById(id);
        return null;
    }

    public Restaurent updateRestaurent(Restaurent restaurent) throws RestaurentAlreadyException {
        if(!restaurentRepository.existsById(restaurent.getId()))
        {
            throw new RestaurentAlreadyException("restaurent not found");
        }
        Restaurent restaurent1= restaurentRepository.save(restaurent);
        return restaurent1;
    }
}
