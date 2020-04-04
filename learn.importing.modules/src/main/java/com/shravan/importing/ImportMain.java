package com.shravan.importing;

import com.shravan.learn.model.User;
import com.shravan.learn.service.DefaultUserService;

public class ImportMain {
    public static void main(String[] args) {
        DefaultUserService defaultUserService = new DefaultUserService();
        defaultUserService.add(new User(1, "Shravan"));
        defaultUserService.add(new User(2, "Navarhs"));
        defaultUserService.print();
        defaultUserService.delete(2);
        defaultUserService.print();

    }
}
