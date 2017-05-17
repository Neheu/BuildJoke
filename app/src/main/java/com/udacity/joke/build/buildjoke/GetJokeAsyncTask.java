package com.udacity.joke.build.buildjoke;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.build.joke.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Neha on 16-05-2017.
 */

public class GetJokeAsyncTask extends AsyncTask<Context,Void,String> {
    private MyApi myApiService = null;
    private Context mContext;
    private CalllBack mCallback;
    public GetJokeAsyncTask(CalllBack callback) {
        mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected final String doInBackground(Context... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://192.168.43.67:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return null;
        }
    }


    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        if (joke == null) {
            Toast.makeText(mContext, "Error occured!", Toast.LENGTH_SHORT).show();
            return;
        }
        mCallback.postExe(joke);
    }

    public interface CalllBack {
        void postExe(String joke);
    }
}

