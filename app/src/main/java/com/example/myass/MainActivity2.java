package com.example.myass;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    EditText firstName2,secondName2,email2,password2;
    Button signoutButton;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstName2=(EditText)findViewById(R.id.firstName2);
        secondName2=(EditText)findViewById(R.id.secondName2);
        email2=(EditText)findViewById(R.id.email2);
        password2=(EditText)findViewById(R.id.firstName2);
        signoutButton=(Button) findViewById(R.id.signupButton);
        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "{" +
                        "\"firstName\"" + ":" + "\"" + firstName2.getText().toString() + "\"," +
                        "\"secondName\"" + ":" + "\"" + secondName2.getText().toString() + "\"," +
                        "\"email\"" + ":" + "\"" + email2.getText().toString() + "\"," +
                        "\"password\"" + ":" + "\"" + password2.getText().toString() + "\"" +
                        "}";
                Submit(data);
            }

            private void Submit(String data) {
                String URL = "https://mcc-users-api.herokuapp.com/add_new_user";
                requestQueue = Volley.newRequestQueue(getApplicationContext());
                Log.d("TAG", "requestQueue: " + requestQueue);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject objres = new JSONObject(response);
                            Log.d("TAG", "onResponse: " + objres.toString());
                        } catch (JSONException e) {
                            Log.d("TAG", "Server Error ");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("TAG", "onErrorResponse: " + error);
                    }
                });
            }


    }
}}