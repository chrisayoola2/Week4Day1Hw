package com.example.week4day1hw;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.net.HttpURLConnection;

public class UserAsyncTask extends AsyncTask<String,String,GithubUserResponse> {
    AsyncCallback asyncCallback;

    public UserAsyncTask (AsyncCallback asyncCallback){
        this.asyncCallback = asyncCallback;
    }

    @Override

    protected GithubUserResponse doInBackground(String... strings) {

        HttpUrlConnection httpUrlConnection = new HttpUrlConnection();
        String responseFromGithub = httpUrlConnection.getJsonFromGithub();

        Gson gson = new Gson();
        GithubUserResponse response = gson.fromJson(responseFromGithub, GithubUserResponse.class);

        return response;
    }



    @Override
    protected void onPostExecute(GithubUserResponse githubUserResponse) {
        super.onPostExecute(githubUserResponse);


        String login = githubUserResponse.getLogin() ;
        String name  = githubUserResponse.getName();
        String bio = githubUserResponse.getBio() ;
        String location =  githubUserResponse.getLocation();
        String company = githubUserResponse.getCompany() ;
        String repoLink = githubUserResponse.getReposUrl();
        Log.d("TAG", login+ name + bio + location + company );
        asyncCallback.returnString(login,name,bio,location,company,repoLink);


    }

    interface AsyncCallback{
        void returnString(String login,String name, String bio, String location, String company,String repoLink);
    }
}
