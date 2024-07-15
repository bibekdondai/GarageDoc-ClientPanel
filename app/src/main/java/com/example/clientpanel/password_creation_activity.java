package com.example.clientpanel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class password_creation_activity extends Activity {

    private EditText editTextPassword, editTextConfirmPassword;
    private Button buttonCreatePassword;
    private String emailAddress, fullName, phoneNumber, address, birthday, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password_creation);

        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonCreatePassword = findViewById(R.id.buttonCreatePassword);

        // Get user details from intent
        emailAddress = getIntent().getStringExtra("email");
        fullName = getIntent().getStringExtra("fullName");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
        address = getIntent().getStringExtra("address");
        birthday = getIntent().getStringExtra("birthday");
        gender = getIntent().getStringExtra("gender");

        buttonCreatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPassword();
            }
        });
    }

    private void createPassword() {
        String password = editTextPassword.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        saveUserDataToDatabase(password);
    }

    private void saveUserDataToDatabase(final String password) {
        String formattedEmail = emailAddress.replace(".", ",");
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(formattedEmail);

        // Create a user object to store all data
        User user = new User(fullName, emailAddress, phoneNumber, address, birthday, gender, password);

        userRef.setValue(user).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(password_creation_activity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                navigateToSignIn();
            } else {
                Toast.makeText(password_creation_activity.this, "Failed to create account", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToSignIn() {
        Intent intent = new Intent(password_creation_activity.this, signin_1_activity.class);
        intent.putExtra("email", emailAddress);
        startActivity(intent);
        finish(); // Optional: Close current activity
    }
}

// User class to store user data
class User {
    public String fullName, emailAddress, phoneNumber, address, birthday, gender, password;
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String fullName, String emailAddress, String phoneNumber, String address, String birthday, String gender, String password) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.password = password;
    }
}
