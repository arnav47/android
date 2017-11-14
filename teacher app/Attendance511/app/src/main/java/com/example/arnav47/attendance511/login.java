package com.example.arnav47.attendance511;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;


public class login  extends AppCompatActivity implements AsyncResponse {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap postData = new HashMap();
                postData.put("btnLogin", "Login");
                postData.put("mobile", "android");
                postData.put("txtUsername", etUsername.getText().toString());
                postData.put("txtPassword", etPassword.getText().toString() );

                PostResponseAsyncTask loginTask =
                        new PostResponseAsyncTask(login.this, postData,
                                login.this);
                loginTask.execute("https://attendance611.000webhostapp.com/login.php");
            }
        });
    }

    @Override
    public void processFinish(String output) {
        Log.wtf("output", output);
        if(output.equals("success")){
            Toast.makeText(this, "Login Successfully",
                    Toast.LENGTH_LONG).show();

            startActivity(new Intent(login.this,bleBeacon.class));
        }
        else
        {
            Toast.makeText(this, "try again",
                    Toast.LENGTH_LONG).show();
        }

    }
}