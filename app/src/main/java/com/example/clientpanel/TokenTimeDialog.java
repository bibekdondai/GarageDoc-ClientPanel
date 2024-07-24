package com.example.clientpanel;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class TokenTimeDialog extends Dialog {

    private static final String TAG = "TokenTimeDialog";

    public interface OnTokenTimeSelectedListener {
        void onTokenTimeSelected(String tokenDate, String tokenTime);
    }

    private OnTokenTimeSelectedListener listener;
    private Context context;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference tokenRef;
    private String plateNumber;

    public TokenTimeDialog(Context context, OnTokenTimeSelectedListener listener, String plateNumber) {
        super(context);
        this.context = context;
        this.listener = listener;
        this.plateNumber = plateNumber;
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        setContentView(R.layout.dialog_token_time);
        initViews();
    }

    private void initViews() {
        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);
        Button selectButton = findViewById(R.id.selectButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        // Initialize DatePicker to allow only the next 7 days, excluding Saturdays
        Calendar calendar = Calendar.getInstance();
        datePicker.setMinDate(calendar.getTimeInMillis());
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        datePicker.setMaxDate(calendar.getTimeInMillis());

        // Initialize TimePicker to show only times between 8 AM and 5 PM
        timePicker.setIs24HourView(true); // Show 24-hour format
        timePicker.setHour(8);
        timePicker.setMinute(0);

        // Restrict TimePicker to valid hours
        timePicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            if (hourOfDay < 8 || hourOfDay >= 17) {
                timePicker.setHour(8);
                timePicker.setMinute(0);
                Toast.makeText(context, "Please select a time between 8 AM and 5 PM", Toast.LENGTH_SHORT).show();
            }
        });

        selectButton.setOnClickListener(v -> {
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, day);

            if (selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                Toast.makeText(context, "Saturdays are not selectable", Toast.LENGTH_SHORT).show();
                return;
            }

            @SuppressLint("DefaultLocale") String tokenDate = String.format("%04d-%02d-%02d", year, month + 1, day);
            @SuppressLint("DefaultLocale") String tokenTime = String.format("%02d:%02d", hour, minute);
            String formattedDateTime = String.format("%s %s", tokenDate, tokenTime);

            Log.d(TAG, "Selected date and time: " + formattedDateTime);

            // Check for existing token
            String email = new SessionManager(context).getEmail();
            if (email != null && !email.isEmpty()) {
                String sanitizedEmail = email.replace(".", ",");
                tokenRef = firebaseDatabase.getReference("users")
                        .child(sanitizedEmail)
                        .child("bikes")
                        .child(plateNumber)
                        .child("services")
                        .child(tokenDate)
                        .child(tokenTime);

                tokenRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            // Token already exists
                            showExistingTokenDialog(dataSnapshot);
                        } else {
                            // No token exists, proceed with token creation
                            if (listener != null) {
                                listener.onTokenTimeSelected(tokenDate, tokenTime);
                            }
                            dismiss();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.e(TAG, "Error checking existing token", databaseError.toException());
                    }
                });
            }
        });

        cancelButton.setOnClickListener(v -> dismiss());
    }

    private void showExistingTokenDialog(DataSnapshot dataSnapshot) {
        new android.app.AlertDialog.Builder(context)
                .setTitle("Token Already Taken")
                .setMessage("You already have a token for this day.")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Redirect to details_to_be_filled_activity with existing token data
                    Intent intent = new Intent(context, details_to_be_filled_activity.class);
                    intent.putExtra("bikeModel", dataSnapshot.child("model").getValue(String.class));
                    intent.putExtra("plateNumber", plateNumber);
                    intent.putExtra("tokenDate", dataSnapshot.child("token_date").getValue(String.class)); // Fixed key here
                    intent.putExtra("tokenTime", dataSnapshot.child("token_time").getValue(String.class)); // Fixed key here
                    context.startActivity(intent);
                })
                .show();
    }
}
