package com.temat20zad1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDataBase {

    private final List<User> userList;

    public UserDataBase() {
        this.userList = new ArrayList<>();
        userList.add(new User("Jan", "Kowalski", 55));
        userList.add(new User("Magda", "Struś", 22));
        userList.add(new User("Stefan", "Batory", 33));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUserToTheList(User user) {
        userList.add(user);
    }
}
