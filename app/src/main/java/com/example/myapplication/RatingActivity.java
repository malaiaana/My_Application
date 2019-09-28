package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        this.getIntent();

        TextView thank;
        final RatingBar ratingbar;

        ratingbar = (RatingBar) findViewById(R.id.ratingBar);
        thank = (TextView) findViewById(R.id.thank);
        Button note = (Button) findViewById(R.id.note);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(RatingActivity.this, "Stars " + (int)v, Toast.LENGTH_SHORT).show();
            }
        });

        note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingActivity.this, "Stars " + (int)ratingbar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
