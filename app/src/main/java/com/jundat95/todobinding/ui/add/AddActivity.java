package com.jundat95.todobinding.ui.add;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jundat95.todobinding.R;
import com.jundat95.todobinding.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        AddViewModel addViewModel = new AddViewModel("Title 1", "Content 1");
        ActivityAddBinding activityAddBinding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        activityAddBinding.setDetail(addViewModel);

        addViewModel.setTitle("new title 2");

    }

}
