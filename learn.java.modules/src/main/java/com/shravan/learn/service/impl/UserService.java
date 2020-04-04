package com.shravan.learn.service.impl;

import com.shravan.learn.model.User;
import com.shravan.learn.store.IUserStore;

import java.util.List;

public class UserService {

    private IUserStore userStore;

    public UserService(IUserStore userStore) {
        this.userStore = userStore;
    }

    public void add(User user) {
        userStore.add(user);
    }

    public void delete(int id) {
        userStore.delete(id);
    }

    public List<User> getAll() {
        return userStore.getAll();
    }
}
