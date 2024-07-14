package com.example.clientpanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class login_option_activity extends BottomSheetDialogFragment {
    private TextView login_option;
    private TextView signup_option;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Set the dialog's background to transparent
        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        View rootView = inflater.inflate(R.layout.login_option, container, false);

        login_option = rootView.findViewById(R.id.login_option);
        signup_option = rootView.findViewById(R.id.signup_option);

        login_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignin1Activity();
            }
        });

        signup_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInfoActivity();
            }
        });

        rootView.findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // Dismiss the bottom sheet
            }
        });

        return rootView;
    }

    private void startSignin1Activity() {
        Intent intent = new Intent(getActivity(), signin_1_activity.class);
        startActivity(intent);
        dismiss(); // Dismiss the bottom sheet after starting the activity
    }
    private void startInfoActivity() {
        Intent intent = new Intent(getActivity(), info_activity.class);
        startActivity(intent);
        dismiss(); // Dismiss the bottom sheet after starting the activity
    }

}
