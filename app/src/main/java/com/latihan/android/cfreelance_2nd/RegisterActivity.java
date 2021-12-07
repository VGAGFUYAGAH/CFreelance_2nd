package com.latihan.android.cfreelance_2nd;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private TextView back, toLoginPage;
    private EditText editUsername, editEmail, editPassword;
    private Button btnCreateUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // NAVIGATION BUTTON
        back = findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, IntroductionActivity.class);
                startActivity(intent);
            }
        });

        toLoginPage = findViewById(R.id.btnToLoginActivity);
        toLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        // ADD TO DATABASE
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        btnCreateUser = findViewById(R.id.btnCreateUser);
        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(editUsername.getText().toString()) || TextUtils.isEmpty(editEmail.getText().toString()) || TextUtils.isEmpty(editPassword.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "You must fill the register form!", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserDatabaseHelper userDB = new UserDatabaseHelper(RegisterActivity.this);
                    userDB.createUser(editUsername.getText().toString().trim(),
                            editEmail.getText().toString().trim(),
                            editPassword.getText().toString().trim());
                }

            }
        });
    }
}