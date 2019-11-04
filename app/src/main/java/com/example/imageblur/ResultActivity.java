package com.example.imageblur;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_IMAGE_RESULT = "extra_image_result";

    ImageView imageResult;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageResult = findViewById(R.id.imgResult);
        btnBack = findViewById(R.id.btnBack);

        if(getIntent().hasExtra(EXTRA_IMAGE_RESULT)){
            Bitmap bitmap = getIntent().getParcelableExtra(EXTRA_IMAGE_RESULT);

            imageResult.setImageBitmap(bitmap);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
