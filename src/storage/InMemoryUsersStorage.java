package storage;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUsersStorage {
    List<User> usersList = new ArrayList<>();

    public Optional<Object> save(User user) {
        usersList.add(user);
        if (usersList.contains(user)) {
//            methodWriter("Such a user already exists. Choose a different nickname.");
            return Optional.of(false);
        }
        return Optional.of(true);
    }

    public Optional<User> byUserName(String username) {
        for (User user : usersList) {
            if (user.getUserName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
