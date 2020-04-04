package com.shravan.learn.store;

import com.shravan.learn.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserStore implements IUserStore {

    private List<User> users;

    private UserStore() {
        users = new ArrayList<>();
    }

    public static UserStore getUserStore() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final UserStore INSTANCE = new UserStore();
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void delete(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
