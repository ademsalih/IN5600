package com.ademsalih.volleyexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        requestQueue = Volley.newRequestQueue(this);
    }

    public void getWebsite(View view) {
        String url = editText.getText().toString();
        String toastMessage = "Getting URL: " + url;
        Toast toast = Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String successMessage = "Request was succeessful";
                Toast successToast = Toast.makeText(getApplicationContext(), successMessage, Toast.LENGTH_SHORT);
                successToast.show();

                String content = response.substring(0,1000);
                Toast responseToast = Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG);
                responseToast.show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMessage = "Something bad happened";
                Toast errorToast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });

        requestQueue.add(stringRequest);
    }
}
