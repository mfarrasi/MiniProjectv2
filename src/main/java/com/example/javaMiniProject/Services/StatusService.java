package com.example.javaMiniProject.Services;

import com.example.javaMiniProject.Entity.Status;
import com.example.javaMiniProject.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private StatusRepository statusRepository;

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Status getStatusById(int id) {
        return statusRepository.findById(id).get();
    }

    public Status createStatus(Status request) {
        Status response = request;

        statusRepository.save(response);
        return response;
    }
}
