package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Bitmap bitmap = this.getIntent().getParcelableExtra("bitmap");
        ImageView image = findViewById(R.id.user_p);

        image.setImageBitmap(bitmap);
    }
}
