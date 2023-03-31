package com.example.volleyballanalaysor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button logInBtn;
    private EditText UsernameIn;

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logInBtn = (Button) findViewById(R.id.logInBtn);
        UsernameIn = (EditText) findViewById(R.id.UserNameIn);

        username = UsernameIn.getText().toString();


        Intent gamesPage = new Intent(this, GamesPage.class);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gamesPage);
            }
        });
    }
}