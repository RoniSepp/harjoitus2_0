package org.roniseppala.harjoitus2_0;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public void saveUsers(Context context){
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e){
            System.out.println("Käyttäjien tallennus ei onnistunut.");
        }
    }

    public void loadUsers(Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen ei onnistunut");
            e.printStackTrace();
    }}

}
