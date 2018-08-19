package com.jundat95.todobinding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jundat95.todobinding.ui.add.AddActivity;
import com.jundat95.todobinding.ui.add.AddViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
