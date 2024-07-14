package com.example.clientpanel;
import android.app.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dialog_enter_otp_activity extends Activity {

    private EditText editTextOTP1, editTextOTP2, editTextOTP3, editTextOTP4;
    private Dialog otpDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_enter_otp);

        editTextOTP1 = findViewById(R.id.editTextOTP1);
        editTextOTP2 = findViewById(R.id.editTextOTP2);
        editTextOTP3 = findViewById(R.id.editTextOTP3);
        editTextOTP4 = findViewById(R.id.editTextOTP4);

        Button btnVerifyOTP = findViewById(R.id.btnVerify);
        Button btnResendOTP = findViewById(R.id.btnResendOTP);

        btnVerifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = editTextOTP1.getText().toString() +
                        editTextOTP2.getText().toString() +
                        editTextOTP3.getText().toString() +
                        editTextOTP4.getText().toString();

                // Validate OTP logic here
                if (otp.length() == 4) {
                    // Proceed with OTP verification
                    Toast.makeText(dialog_enter_otp_activity.this, "Verifying OTP...", Toast.LENGTH_SHORT).show();
                    // Call your OTP verification method
                    // otpVerificationMethod(otp);
                    // Dismiss dialog after verification
                    navigateToPasswordCreation();

                    finish();
                    // Navigate to next activity or perform desired action
                    // navigateToPasswordCreation();
                } else {
                    Toast.makeText(dialog_enter_otp_activity.this, "Please enter valid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnResendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Resend OTP logic here
                Toast.makeText(dialog_enter_otp_activity.this, "Resending OTP...", Toast.LENGTH_SHORT).show();
                // Call your resend OTP method
                // resendOTPMethod();
            }
        });
    }

    private void navigateToPasswordCreation() {
        Intent intent = new Intent(dialog_enter_otp_activity.this, password_creation_activity.class);
        startActivity(intent);
        // Optional: You can finish this activity if needed
        // finish();
    }
}
