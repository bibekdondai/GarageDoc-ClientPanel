package com.example.clientpanel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class cctv_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cctv);

        ImageView cctv1 = findViewById(R.id.cctv1);
        ImageView cctv2 = findViewById(R.id.cctv2);
        ImageView cctv3 = findViewById(R.id.cctv3);
        ImageView cctv4 = findViewById(R.id.cctv4);

        // Assuming you have URLs for your CCTV images
        String cctv1Url = "http://example.com/path/to/cctv1.jpg";
        String cctv2Url = "http://example.com/path/to/cctv2.jpg";
        String cctv3Url = "http://example.com/path/to/cctv3.jpg";
        String cctv4Url = "http://example.com/path/to/cctv4.jpg";

        // Load CCTV images using Glide
        Glide.with(this)
                .load(cctv1Url)
                .placeholder(R.drawable.placeholder_image) // Optional: a placeholder image
                .error(R.drawable.error_image) // Optional: an error image
                .into(cctv1);

        Glide.with(this)
                .load(cctv2Url)
                .placeholder(R.drawable.placeholder_image) // Optional: a placeholder image
                .error(R.drawable.error_image) // Optional: an error image
                .into(cctv2);
        Glide.with(this)
                .load(cctv3Url)
                .placeholder(R.drawable.placeholder_image) // Optional: a placeholder image
                .error(R.drawable.error_image) // Optional: an error image
                .into(cctv3);
        Glide.with(this)
                .load(cctv4Url)
                .placeholder(R.drawable.placeholder_image) // Optional: a placeholder image
                .error(R.drawable.error_image) // Optional: an error image
                .into(cctv4);
    }

}
