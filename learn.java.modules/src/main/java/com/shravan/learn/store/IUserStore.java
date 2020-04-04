package com.shravan.learn.store;

import com.shravan.learn.model.User;

import java.util.List;

public interface IUserStore {

    void add(User user);
    void delete(int id);
    List<User> getAll();
}
