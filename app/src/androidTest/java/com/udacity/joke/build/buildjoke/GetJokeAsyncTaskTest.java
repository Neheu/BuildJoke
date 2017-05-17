package com.udacity.joke.build.buildjoke;

import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;
import android.util.Log;

import com.udacity.joke.build.buildjoke.paid.JokeFragment;

import java.util.concurrent.ExecutionException;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Neha on 16-05-2017.
 */
@RunWith(AndroidJUnit4.class)

public class GetJokeAsyncTaskTest {
    private static final String TAG = GetJokeAsyncTaskTest.class.getSimpleName();
@Test
    public void testDoInBackground() throws Exception {
        JokeFragment fragment = new JokeFragment();
        GetJokeAsyncTask task = new GetJokeAsyncTask(fragment);
        try {
            String joke = task.get();
            Log.d(TAG, "Joke text: " + joke);
            assertNotNull(joke);
            assertTrue(joke.length() > 0);
        } catch (InterruptedException | ExecutionException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

    }

