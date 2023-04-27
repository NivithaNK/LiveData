package com.example.simple_mvvm.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.simple_mvvm.R;

public class SampleTestingActivity extends AppCompatActivity {

    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_testing);
        myViewModel = new ViewModelProvider(SampleTestingActivity.this).get(MyViewModel.class);

        myViewModel.getMyNameFromServer();

        myViewModel.getNameLiveData().observe(SampleTestingActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //set text / ui interaction
            }
        });

    }
}