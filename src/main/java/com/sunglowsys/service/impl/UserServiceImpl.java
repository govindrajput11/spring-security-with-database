package com.sunglowsys.service.impl;

import com.sunglowsys.domain.User;
import com.sunglowsys.repository.UserRepository;
import com.sunglowsys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        log.debug("request to save user :{}", user);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.debug("request to update user:{}", user);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getOne(Long id) {
        log.debug("request to get user :{}", id);
        return userRepository.findById(id);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        log.debug("request to get Users :{}",pageable);
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        log.debug("request to delete user :{}",id);
        userRepository.deleteById(id);
    }
}
