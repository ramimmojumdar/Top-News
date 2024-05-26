package com.example.topnews;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class NextActivity extends AppCompatActivity {

    ImageView newsImage;
    TextView newsTitle;
    TextView newsDes;

    public static String TITLE = "";
    public static String DESCRIPTION = "";
    public static Bitmap MY_BITMAP = null;

    TextToSpeech textToSpeech;
    FloatingActionButton sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        newsImage = findViewById(R.id.newsImage);
        newsTitle = findViewById(R.id.newsTitle);
        newsDes = findViewById(R.id.newsDes);
        sound = findViewById(R.id.sound);

        newsTitle.setText(TITLE);
        newsDes.setText(DESCRIPTION);

        if(MY_BITMAP != null) newsImage.setImageBitmap(MY_BITMAP);


//        textToSpeech = new TextToSpeech(NextActivity.this, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int i) {
//
//            }
//        });
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        // Handle the error
                    }
                } else {
                    // Initialization failed
                }
            }
        });


        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = newsDes.getText().toString();
                textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });


//        sound.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });

    }

}