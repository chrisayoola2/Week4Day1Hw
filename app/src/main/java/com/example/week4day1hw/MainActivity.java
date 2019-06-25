package com.example.week4day1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements UserAsyncTask.AsyncCallback {

    TextView tvLogin;
    TextView tvName;
    TextView tvBio;
    TextView tvLocation;
    TextView tvCompany;
    TextView tvRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLogin = findViewById(R.id.tvLogin);
        tvName = findViewById(R.id.tvName);
        tvBio = findViewById(R.id.tvBio);
        tvLocation = findViewById(R.id.tvLocation);
        tvCompany = findViewById(R.id.tvCompany);
        tvRepo = findViewById(R.id.tvRepo);
        UserAsyncTask personalAsyncTask = new UserAsyncTask(this);
        personalAsyncTask.execute("string");

    }


    @Override
    public void returnString(String login, String name, String bio, String location, String company, String repo) {
        tvLogin.setText(login);
        tvName.setText(name);
        tvBio.setText(bio);
        tvCompany.setText(company);
        tvLocation.setText(location);
        tvRepo.setText(repo);



    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(),GitRepoActivity.class);
        startActivity(intent);
    }
}
