package com.example.arnav47.attendance511;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView2;
    Button button;

    private static final int REQUEST_CODE_PERMISSION = 1;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button button = (Button)findViewById(R.id.button);
        GPSTracker tracker = new GPSTracker(this);
        tracker.getLocation();
        Toast.makeText(MainActivity.this, "latitude is "+tracker.getLatitude()+"\n longitude is "+tracker.getLongitude(), Toast.LENGTH_SHORT).show();

        if(3>2)
        {
            textView2.setVisibility(textView2.VISIBLE);
            button.setVisibility(button.VISIBLE);

        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,login.class));
            }
        });


    }






}

