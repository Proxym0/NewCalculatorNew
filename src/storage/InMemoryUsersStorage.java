package storage;

import entity.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUsersStorage {
    List<Users> usersList = new ArrayList<>();

    public void save(Users user) {
        usersList.add(user);
    }

    public Optional<Users> byUserName(String username) {
        for (Users user : usersList) {
            if (user.getUserName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
