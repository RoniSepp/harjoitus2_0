package org.roniseppala.harjoitus2_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ActivityListUsers extends AppCompatActivity {

    private UserStorage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        storage = UserStorage.getInstance();
        ArrayList<User> tempUsers = storage.getUsers();

        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getLastName().compareTo(t1.getLastName());
            }
        };

        Collections.sort(tempUsers, comparator);

        recyclerView = findViewById(R.id.rvUserList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserListAdapter(getApplicationContext(), tempUsers));

    }
}