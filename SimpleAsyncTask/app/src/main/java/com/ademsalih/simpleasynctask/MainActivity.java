package com.ademsalih.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        new SimpleAsyncTask(mTextView).execute();
        Log.d("MainActivity", "Starting task...");
    }
}
