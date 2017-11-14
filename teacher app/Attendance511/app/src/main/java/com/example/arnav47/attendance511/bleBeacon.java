package com.example.arnav47.attendance511;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseSettings;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.uriio.beacons.Beacons;
import com.uriio.beacons.model.EddystoneUID;

public class bleBeacon extends AppCompatActivity {
    Button button2;
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter mBluetoothAdapter;
    // Initializes Bluetooth adapter.
    BluetoothManager bluetoothManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble_beacon);

        Beacons.initialize(this);


        bluetoothManager =
                (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    public void checkAttendance(View view){
        startActivity(new Intent(bleBeacon.this,viewData.class));
    }

    public void sendBeacon(View view){
        String uuid="0000feaa-0000-1000-8000-00805f9b34fb";
//        new iBeacon(uuid.getBytes(), 0,0).start();
////        new EddystoneURL("https://www.facebook.com").start();

        EddystoneUID beacon= new EddystoneUID(uuid.getBytes(), AdvertiseSettings.ADVERTISE_MODE_BALANCED, AdvertiseSettings.ADVERTISE_TX_POWER_LOW);
        beacon.edit().setName("attendance beacon").apply();

        beacon.start();
    }
}
