package service;

import entity.Users;
import storage.InMemoryUsersStorage;

import java.util.Optional;

public class UserService {
    InMemoryUsersStorage userStorage=new InMemoryUsersStorage();

    public void create(Users user) {
        userStorage.save(user);
    }
    public Optional<Users> findByUserName(String username){
        return userStorage.byUserName(username);}
}