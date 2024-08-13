package com.lucasteixeira.workshopmongodb.Services;

import com.lucasteixeira.workshopmongodb.Services.exception.ObjectNotFoundException;
import com.lucasteixeira.workshopmongodb.domain.User;
import com.lucasteixeira.workshopmongodb.dto.UserDTO;
import com.lucasteixeira.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
       return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found with id" + id));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDto(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

}
