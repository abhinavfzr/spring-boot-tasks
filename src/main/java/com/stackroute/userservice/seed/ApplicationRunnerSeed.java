package com.stackroute.userservice.seed;

import com.stackroute.userservice.domain.Restaurent;
import com.stackroute.userservice.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerSeed implements ApplicationListener {
    private RestaurentRepository restaurentRepository;

    @Autowired
    public ApplicationRunnerSeed(RestaurentRepository restaurentRepository) {
        this.restaurentRepository = restaurentRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        Restaurent restaurent = new Restaurent(1, "dhaba", "image", "kormangala");
        restaurentRepository.save(restaurent);
    }
}
