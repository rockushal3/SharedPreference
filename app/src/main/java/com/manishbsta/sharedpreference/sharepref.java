package com.manishbsta.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class sharepref extends AppCompatActivity {

    EditText user,pass;
    CheckBox check;
    SharedPreferences sharedPreferences;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepref);

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        check = findViewById(R.id.check);
        login = findViewById(R.id.login);

        SharedPreferences savedata = getSharedPreferences("User", Context.MODE_PRIVATE);

        if (savedata.getString("username","").isEmpty()){
            check.setChecked(false);
        }
        else {
            user.setText(savedata.getString("username",""));
            pass.setText(savedata.getString("password",""));
            check.setChecked(true);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check.isChecked()){
                    String use =user.getText().toString();
                    String pas = pass.getText().toString();

                    sharedPreferences = getSharedPreferences("User",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("username",use);
                    editor.putString("password",pas);
                    editor.commit();
                    Toast.makeText(sharepref.this, "checked", Toast.LENGTH_SHORT).show();
                }
                else {
                    sharedPreferences = getSharedPreferences("User",0);
                    sharedPreferences.edit().clear().commit();
                    Toast.makeText(sharepref.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
