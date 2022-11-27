package com.sunglowsys.service;

import com.sunglowsys.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User save(User user);
    User update(User user);
    Optional<User> getOne(Long id);
    Page<User> getAll(Pageable pageable);
    void delete(Long id);
}
