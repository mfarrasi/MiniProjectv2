package com.example.javaMiniProject.Services;

import com.example.javaMiniProject.Entity.Status;
import com.example.javaMiniProject.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public Status createStatus (Status request) {
        Status response = request;

        statusRepository.save(response);

        return response;

    }
    public Status getStatus (String param) {
        Status response = new Status();
        response = statusRepository.findById(Integer.valueOf(param)).get();

        return response;
    }
    public Status updateStatus (Status param) {
        Status response = new Status();

        response = statusRepository.findById(param.getStatusId()).get();

        statusRepository.save(response);

        return response;
    }
    public Status deleteStatus(String param) {

        try{
            statusRepository.deleteById(Integer.valueOf(param));
            Status response = new Status();
//            response.setRc("0000");
//            response.setRcDesc("Succcessfully delete user id");

            return response;
        } catch (Exception e) {
            Status response = new Status();
//            response.setRc("0005");
//            response.setRcDesc("failed to delete user id");

            return response;


        }


    }
}
