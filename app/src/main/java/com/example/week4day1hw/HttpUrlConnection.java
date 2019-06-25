package com.example.week4day1hw;


import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//STEP 1 CREATE A URL CONNECTION CLASS
public class HttpUrlConnection {

    public String getJsonFromGithub(){
        String jsonResult = "";
        HttpURLConnection httpUrlConnection = null;

        try {
            URL userGithubUrl = new URL("https://api.github.com/users/chrisayoola2"); //Connect to the URL
            httpUrlConnection = (HttpURLConnection)userGithubUrl.openConnection();
            InputStream inputStream = httpUrlConnection.getInputStream();

            int currentReadCharAsciiValue = inputStream.read();
            while (currentReadCharAsciiValue != -1){
                char currentChar = (char)currentReadCharAsciiValue;
                currentReadCharAsciiValue = inputStream.read();
                jsonResult = jsonResult + currentChar;
            }

        }catch (Exception e ){
            Log.d("TAG", "Error in Http Connection" , e);
        }finally {

            if (httpUrlConnection != null){
                httpUrlConnection.disconnect();
            }
        }

        return jsonResult;
    }

    public String getReposFromGitHub(){
        String jsonReposResult = "";
        HttpURLConnection httpUrlConnection = null;


        try{
            URL reposGitHubUrl = new URL("https://api.github.com/users/chrisayoola2/repos");
            httpUrlConnection = (HttpURLConnection)reposGitHubUrl.openConnection();
            InputStream inputStream = httpUrlConnection.getInputStream();

            int currentReadCharAsciiValue = inputStream.read();
            while (currentReadCharAsciiValue != -1) {
                char currentChar = (char) currentReadCharAsciiValue;
                currentReadCharAsciiValue = inputStream.read();
                jsonReposResult = jsonReposResult + currentChar;
            }
            Log.d("TAG", "HEREEEEBBBRRRRRRRAAAAABAAa");

        }catch (Exception e){
            Log.d("TAG", "Error in Http Connection" , e);
        }finally {
            if (httpUrlConnection != null){
                httpUrlConnection.disconnect();
            }
        }
        return jsonReposResult;
    }
}
