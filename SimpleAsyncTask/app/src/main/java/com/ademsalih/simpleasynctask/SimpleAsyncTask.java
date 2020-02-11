package com.ademsalih.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;


    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        mTextView.get().setText(s);
    }

    @Override
    protected String doInBackground(Void... voids) {

        Random random = new Random();
        int n = random.nextInt(100);

        int s = n * 200;


        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Awake at last after sleeping for " + s + " milliseconds";
    }
}
