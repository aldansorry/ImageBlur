package com.example.imageblur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView txtWelcomeMessage;
    Button btnCamera,btnLogout;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        btnCamera = findViewById(R.id.btnCamera);
        btnLogout = findViewById(R.id.btnLogout);

        mAuth = FirebaseAuth.getInstance();

        txtWelcomeMessage.setText("Hai, "+mAuth.getCurrentUser().getEmail());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,"Back button is disabled",Toast.LENGTH_SHORT).show();
        return;
    }
}
