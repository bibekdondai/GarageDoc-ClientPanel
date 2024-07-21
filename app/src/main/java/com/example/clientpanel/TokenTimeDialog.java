package com.example.clientpanel;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class TokenTimeDialog extends Dialog {

    public interface OnTokenTimeSelectedListener {
        void onTokenTimeSelected(String selectedTime);
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
        TimePicker timePicker = findViewById(R.id.timePicker);
        Button selectButton = findViewById(R.id.selectButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        selectButton.setOnClickListener(v -> {
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();
            String selectedTime = String.format("%02d:%02d", hour, minute);
            Log.d("TokenTimeDialog", "Selected time: " + selectedTime);
            if (listener != null) {
                listener.onTokenTimeSelected(selectedTime);
            }
            // Create an Intent to start details_to_be_filled_activity
            Intent intent = new Intent(context, details_to_be_filled_activity.class);
            intent.putExtra("selectedTime", selectedTime);
            context.startActivity(intent);
            dismiss();
        });

        cancelButton.setOnClickListener(v -> dismiss());
    }
}
