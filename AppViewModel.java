package com.example.simple_mvvm;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class AppViewModel extends BaseObservable {

    private User user;

    private String successMessage = "Login successfully";
    private String errorMessage = "Invalid";

    private String toastMessage = null;

    @Bindable
    public String getUserEmail(){
        return user.getEmail();
    }

    public void setUserEmail(String name){
        user.setEmail(name);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getToastmessage(){
        return toastMessage;
    }

    public void setToastmessage(String toastMessage){
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastmessage);
    }

    @Bindable
    public String getPassword(){
        return user.getPassword();
    }

    public void setPassword(String password){
        user.setPassword(password);
        notifyPropertyChanged(BR.password);
    }

    public AppViewModel(){
        user = new User(" "," ");
    }

    public void onButtonClicked(){

        if(isInputDataValid()){
             setToastmessage(successMessage);
        }
        else{
            setToastmessage(errorMessage);
        }
    }

    private boolean isInputDataValid() {
        return getUserEmail().length() > 5;
    }
}
