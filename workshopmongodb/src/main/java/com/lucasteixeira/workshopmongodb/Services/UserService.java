package com.lucasteixeira.workshopmongodb.Services;

import com.lucasteixeira.workshopmongodb.domain.User;
import com.lucasteixeira.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
