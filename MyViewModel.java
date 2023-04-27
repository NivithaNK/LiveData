package com.example.simple_mvvm.sample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<String> nameLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getNameLiveData() {
        return nameLiveData;
    }

    public void setNameLiveData(String input) {
        this.nameLiveData.postValue(input);
    }

    public MyViewModel(@NonNull Application application) {
        super(application);
    }


    public void getMyNameFromServer() {
        //big process - server get and come
        setNameLiveData("Sample setting");
        //retrofit
    }
}
