package com.example.week4day1hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

public class GitRepoActivity extends AppCompatActivity implements GitRepoAsyncTask.AsyncCallbackRepo{
    private RecyclerView rvRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_repo);
        rvRecyclerView = findViewById(R.id.rvRecyclerView);
       GitRepoAsyncTask repositoryAsyncTask = new GitRepoAsyncTask(this);
       repositoryAsyncTask.execute("someString");


    }

    @Override
    public void returnString(String login, String name, String bio, String location, String company, String repoLink) {

    }
}
