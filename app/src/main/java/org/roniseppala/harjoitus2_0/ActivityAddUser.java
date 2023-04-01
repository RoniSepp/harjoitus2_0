package org.roniseppala.harjoitus2_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ActivityAddUser extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private RadioGroup ala;

    private UserStorage storage = UserStorage.getInstance();
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        email = findViewById(R.id.txtEmail);
        ala = findViewById(R.id.rgAla);

        context = ActivityAddUser.this;
    }

    public void addUser(View view){
        String alaString = "";
        switch (ala.getCheckedRadioButtonId()){
            case R.id.rbTiTe:
                alaString = "Tietotekniikka";
                break;
            case R.id.rbTuTa:
                alaString = "Tuotantotalous";
                break;
            case R.id.rbLaTe:
                alaString = "Laskennallinen tekniikka";
                break;
            case R.id.rbSäte:
                alaString = "Sähkötekniikka";
                break;
        }
        storage.addUser(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), alaString);
        storage.saveUsers(context);

    }
}