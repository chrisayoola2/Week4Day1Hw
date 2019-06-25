package com.example.week4day1hw;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

public class GitRepoAsyncTask extends AsyncTask<String,String,GithuRepoResponse> {
    AsyncCallbackRepo asyncCallbackRepo;

   public GitRepoAsyncTask(AsyncCallbackRepo asyncCallbackRepo){
       this.asyncCallbackRepo = asyncCallbackRepo;
   }
    @Override
    protected GithuRepoResponse doInBackground(String... strings) {

        HttpUrlConnection httpUrlConnection2 = new HttpUrlConnection();

        String repoResponseFromGithub = httpUrlConnection2.getReposFromGitHub();
        Log.d("TAG", "HEREEEEBBBBAAa");
        Gson gson = new Gson();
        GithuRepoResponse response = gson.fromJson(repoResponseFromGithub, GithuRepoResponse.class);

        Log.d("TAG", "HEREEEE");
        return response;
    }

    @Override
    protected void onPostExecute(GithuRepoResponse githuRepoResponse) {
        super.onPostExecute(githuRepoResponse);
        Log.d("TAG", githuRepoResponse.getId().toString());


    }

    interface AsyncCallbackRepo{
        void returnString(String login,String name, String bio, String location, String company,String repoLink);
    }
}
