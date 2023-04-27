package com.example.simple_mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.simple_mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MutableLiveData<String> name = new MutableLiveData<>();
        name.postValue("abc");


        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        activityMainBinding.setViewModel(new AppViewModel());
        activityMainBinding.executePendingBindings();
        activityMainBinding.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                  Toast.makeText(getApplicationContext(),charSequence,Toast.LENGTH_SHORT).show();
                  //String typetext = charSequence.toString();
                  //activityMainBinding.email.setText(typetext);
                name.postValue(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        name.observe(MainActivity.this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                  activityMainBinding.email.setText(s);

            }
        });
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message,Toast.LENGTH_SHORT).show();

    }
}



