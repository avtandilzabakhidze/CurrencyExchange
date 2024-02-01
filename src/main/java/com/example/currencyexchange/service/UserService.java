package com.example.currencyexchange.service;

import com.example.currencyexchange.domain.User;
import com.example.currencyexchange.dto.UserDTO;
import com.example.currencyexchange.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Iterable<User> getUser() {
        return repository.findAll();
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = repository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }
}
