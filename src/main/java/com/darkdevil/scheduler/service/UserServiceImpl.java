package com.darkdevil.scheduler.service;

import com.darkdevil.scheduler.model.User;
import com.darkdevil.scheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Scheduled(fixedRate = 2000)
    public void add2DBJob(){
        User user = new User();
        user.setName("user" + new Random().nextInt(374483));
        userRepository.save(user);
        System.out.println("add service call in " + new Date().toString());
    }

}
