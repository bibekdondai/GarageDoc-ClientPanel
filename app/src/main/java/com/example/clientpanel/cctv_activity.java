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

        // URLs for test CCTV images
        String cctv1Url = "http://example.com/path/to/cctv1.jpg";
        String cctv2Url = "http://example.com/path/to/cctv2.jpg";

        // Test RTSP URLs
        String cctv1StreamUrl = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov";
        String cctv2StreamUrl = "rtsp://media.cdn.corp.google.com:554/test";

        // Load CCTV images using Glide
        Glide.with(this)
                .load(cctv1Url)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(cctv1);

        Glide.with(this)
                .load(cctv2Url)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(cctv2);

        cctv1.setOnClickListener(v -> {
            Intent intent = new Intent(cctv_activity.this, fullscreenvideo.class);
            intent.putExtra("STREAM_URL", cctv1StreamUrl);
            startActivity(intent);
        });

        cctv2.setOnClickListener(v -> {
            Intent intent = new Intent(cctv_activity.this, fullscreenvideo.class);
            intent.putExtra("STREAM_URL", cctv2StreamUrl);
            startActivity(intent);
        });
    }
}
