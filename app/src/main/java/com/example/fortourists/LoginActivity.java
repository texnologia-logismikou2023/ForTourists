    package com.example.fortourists;

import com.example.fortourists.DatabaseHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.widget.Toast.LENGTH_SHORT;

    public class LoginActivity extends AppCompatActivity {

        private EditText editTextUsername, editTextPassword;
        private Button btnLogin;
        private DatabaseHelper dbHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            editTextUsername = findViewById(R.id.usernameEditText);
            editTextPassword = findViewById(R.id.usernameEditText);
            btnLogin = findViewById(R.id.loginButton);
            dbHelper = new DatabaseHelper(this);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginUser();
                }
            });
        }

        private void loginUser() {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                if (dbHelper.checkUser(username, password)) {
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Redirect to main activity or perform any other action
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            }
        }
    }
