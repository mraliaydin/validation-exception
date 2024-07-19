package org.aliaydin.validationexception.service;

import lombok.AllArgsConstructor;
import org.aliaydin.validationexception.dto.UserRequest;
import org.aliaydin.validationexception.entity.User;
import org.aliaydin.validationexception.exception.UserNotFoundException;
import org.aliaydin.validationexception.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest){

        User user =  new User(0,userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());


        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return user;
    }
}
