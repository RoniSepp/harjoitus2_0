package org.roniseppala.harjoitus2_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ActivityAddUser extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private RadioGroup ala;
    private CheckBox cbKandi;
    private CheckBox cbDi;
    private CheckBox cbTohtori;
    private CheckBox cbUima;

    private UserStorage storage = UserStorage.getInstance();
    private Context context;
    private Boolean tempIsKandi;
    private Boolean tempIsDI;
    private Boolean tempIsTohtori;
    private Boolean tempIsUima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = findViewById(R.id.txtFirstName);
        lastName = findViewById(R.id.txtLastName);
        email = findViewById(R.id.txtEmail);
        ala = findViewById(R.id.rgAla);
        cbKandi = findViewById(R.id.cbKandi);
        cbDi = findViewById(R.id.cbDI);
        cbTohtori = findViewById(R.id.cbTohtori);
        cbUima = findViewById(R.id.cbUimamaisteri);

        context = ActivityAddUser.this;


        tempIsKandi = false;
        tempIsDI = false;
        tempIsTohtori = false;
        tempIsUima = false;

        cbKandi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                tempIsKandi = isChecked;
            }
        });

        cbDi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    tempIsDI = true;
                } else {
                    tempIsDI = false;
                }
            }
        });

        cbTohtori.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    tempIsTohtori = true;
                } else {
                    tempIsTohtori = false;
                }
            }
        });

        cbUima.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    tempIsUima = true;
                } else {
                    tempIsUima = false;
                }
            }
        });
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



        storage.addUser(firstName.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                alaString,
                tempIsKandi,
                tempIsDI,
                tempIsTohtori,
                tempIsUima);


        storage.saveUsers(context);

    }
}