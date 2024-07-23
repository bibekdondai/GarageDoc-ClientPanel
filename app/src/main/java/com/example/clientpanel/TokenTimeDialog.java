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

import java.util.Calendar;

public class TokenTimeDialog extends Dialog {

    public interface OnTokenTimeSelectedListener {
        void onTokenTimeSelected(String selectedDateTime);
    }

    private OnTokenTimeSelectedListener listener;
    private Context context;

    public TokenTimeDialog(Context context, OnTokenTimeSelectedListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
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
        timePicker.setIs24HourView(false); // Show AM/PM
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
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, day);

            if (selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                Toast.makeText(context, "Saturdays are not selectable", Toast.LENGTH_SHORT).show();
                return;
            }

            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            boolean isPM = hour >= 12;
            @SuppressLint("DefaultLocale") String formattedDateTime = String.format("%04d-%02d-%02d %02d:%02d %s",
                    year, month + 1, day,
                    (hour % 12 == 0) ? 12 : (hour % 12),
                    minute,
                    isPM ? "PM" : "AM");

            Log.d("TokenTimeDialog", "Selected date and time: " + formattedDateTime);
            if (listener != null) {
                listener.onTokenTimeSelected(formattedDateTime);
            }

            // Create an Intent to start details_to_be_filled_activity
            Intent intent = new Intent(context, details_to_be_filled_activity.class);
            intent.putExtra("selectedDateTime", formattedDateTime);
            context.startActivity(intent);
            dismiss();
        });

        cancelButton.setOnClickListener(v -> dismiss());
    }
}
