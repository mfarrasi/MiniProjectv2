package com.example.javaMiniProject.Services;

import com.example.javaMiniProject.Entity.User;
import com.example.javaMiniProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser (User request) {
        User response = request;

        userRepository.save(response);

        return response;

    }
    public User getUser (String param) {
        User response = new User();
        response = userRepository.findById(Integer.valueOf(param)).get();

        return response;
    }
    public User updateUser (User param) {
        User response = new User();

        response = userRepository.findById(param.getUserId()).get();

        userRepository.save(response);

        return response;
    }
    public User deleteUser(String param) {

        try{
            userRepository.deleteById(Integer.valueOf(param));
            User response = new User();
//            response.setRc("0000");
//            response.setRcDesc("Succcessfully delete user id");

            return response;
        } catch (Exception e) {
            User response = new User();
//            response.setRc("0005");
//            response.setRcDesc("failed to delete user id");

            return response;


        }


    }


}
