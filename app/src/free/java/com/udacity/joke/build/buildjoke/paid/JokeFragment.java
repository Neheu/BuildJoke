package com.udacity.joke.build.buildjoke.paid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.build.joke.myApi.MyApi;
import com.udacity.joke.build.buildjoke.GetJokeAsyncTask;
import com.udacity.joke.build.buildjoke.R;
import com.udacity.joke.build.jokeviewer.JokeViewActivity;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class JokeFragment extends Fragment implements GetJokeAsyncTask.CalllBack{
    private ProgressBar mProgressBar;

    public JokeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_joke, container, false);
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
//                // Check the LogCat to get your test device ID
                .addTestDevice("22C3F2C2255B69CCC7FB0341D7B47D3F")
                .build();
        mAdView.loadAd(adRequest);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        ((Button)root.findViewById(R.id.tell_joke_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                new GetJokeAsyncTask(JokeFragment.this).execute(getActivity());
            }
        });

        mProgressBar.setVisibility(View.GONE);
        return root;
    }

    @Override
    public void postExe(String joke) {

        mProgressBar.setVisibility(View.GONE);
        getActivity().startActivity(new Intent(getActivity(),JokeViewActivity.class).putExtra("Joke",joke));
    }


}

