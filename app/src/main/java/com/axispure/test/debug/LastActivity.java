package com.axispure.test.debug;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_layout);
        ImageView loader = findViewById(R.id.loader);
        Glide.with(this)
                .asGif()
                .load(R.drawable.opc_ajax_loader)
                .into(loader);
    }

}
