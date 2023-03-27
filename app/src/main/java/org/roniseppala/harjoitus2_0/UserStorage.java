package org.roniseppala.harjoitus2_0;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage storage = null;

    private UserStorage(){

    }

    public static UserStorage getInstance(){
        if (storage == null){
            storage = new UserStorage();
        }
        return storage;
    }

    public void addUser(String firstName, String lastName, String email, String ala){
        users.add(new User(firstName, lastName, email, ala));
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}
