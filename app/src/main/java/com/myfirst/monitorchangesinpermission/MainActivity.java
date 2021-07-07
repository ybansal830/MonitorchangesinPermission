package com.myfirst.monitorchangesinpermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE = 0;
    private Button mBtOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtOne = findViewById(R.id.btOne);
        mBtOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(MainActivity.this, "storage and Location permission granted", Toast.LENGTH_SHORT).show();
        else if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_DENIED)
            Toast.makeText(MainActivity.this, "storage granted and Location permission denied", Toast.LENGTH_SHORT).show();
        else if (grantResults[0] == PackageManager.PERMISSION_DENIED && grantResults[1] == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(MainActivity.this, "storage denied and Location permission granted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Both the permissions denied", Toast.LENGTH_SHORT).show();
    }
}