package org.roniseppala.harjoitus2_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        UserStorage.getInstance().loadUsers(context);

    }

    public void switchToAddUser(View view){
        Intent intent = new Intent(this, ActivityAddUser.class);
        startActivity(intent);
    }

    public void switchToListUsers(View view){
        Intent intent = new Intent(this, ActivityListUsers.class);
        startActivity(intent);
    }
}