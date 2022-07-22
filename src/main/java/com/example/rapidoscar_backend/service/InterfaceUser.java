package com.example.rapidoscar_backend.service;

import com.example.rapidoscar_backend.entity.User;

import java.util.List;

public interface InterfaceUser {

    User save(User user);

    void delete(Integer id);

    User update(User user, Integer id);

    List<User> getAll();
}
