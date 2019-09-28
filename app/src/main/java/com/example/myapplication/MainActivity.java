package com.example.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Bitmap UserImage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final NotificationManager notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                final Notification notify = new Notification.Builder
                        (getApplicationContext()).setContentTitle("Уведомление отправлено!!!").setContentText("Вы великолепны!+++++++++++++++++++++++++++++++++++++++++++++" +
                        "" +
                        "+++").
                        setSmallIcon(R.drawable.ic_launcher_foreground).build();

                notify.flags |= Notification.FLAG_AUTO_CANCEL;


                new CountDownTimer(10000, 10000) {
                    public void onTick(long time) {
                    }

                    public void onFinish() {
                        if (notif != null)
                            notif.notify(0, notify);
                    }
                }.start();
            }
        });


        final EditText InputS;

        InputS = findViewById(R.id.request);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/#q=" + InputS.getText())));
            }
        });

        final RadioGroup radio_group = findViewById(R.id.check_group);
        Button photo = findViewById(R.id.photo);

        photo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (radio_group.getCheckedRadioButtonId() == R.id.front) {
                    Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    takePic.putExtra("android.intent.extras.CAMERA_FACING", 1);
                    startActivityForResult(takePic, 1);
                } else {
                    Intent takePic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    takePic.putExtra("android.intent.extras.CAMERA_FACING", 0);
                    startActivityForResult(takePic, 1);
                }
            }
        });

        Button ShowImage = findViewById(R.id.show_i);
        ShowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
                intent.putExtra("bitmap", UserImage);
                startActivity(intent);
            }
        });

        Button notice = (Button) findViewById(R.id.new_act);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult ( int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK) {
            UserImage = (Bitmap) data.getExtras().get("data");
        }
    }
}