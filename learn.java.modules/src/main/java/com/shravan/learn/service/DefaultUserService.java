package com.shravan.learn.service;

import com.shravan.learn.model.User;
import com.shravan.learn.service.impl.UserService;

import java.util.List;

import static com.shravan.learn.store.UserStore.getUserStore;

public class DefaultUserService extends UserService {

    public DefaultUserService() {
        super(getUserStore());
    }

    public void print() {
        List<User> users = getAll();
        System.out.println("users = " + users);
    }
}
