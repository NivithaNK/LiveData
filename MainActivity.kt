package com.example.formvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.util.Patterns.EMAIL_ADDRESS
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.example.formvalidation.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    var sample:String? = null
    var sampleWithoutNull:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        emailFocusListner()
        passwordFocusListner()
        PhoneNoFocusListner()

//        if(sample!=null){
//            sample.length
//        }

        val len=sample?.length //NotNull. find the length

        val len2=sampleWithoutNull.length

    }

    private fun emailFocusListner() {
        binding.emailid.setOnFocusChangeListener { _, focused ->

            if(!focused){
                binding.textInputLayout7.helperText = validEmail()
            }
        }
    }

    private fun passwordFocusListner() {
        binding.passwordid.setOnFocusChangeListener{ _, focused ->

            if(!focused){
                binding.textInputLayout8.helperText = validPassword()
            }
        }
    }

    private fun  PhoneNoFocusListner(){
        binding.phoneno.setOnFocusChangeListener{_,focused ->

            if(!focused){
                binding.textInputLayout9.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String? {

        val phone = binding.phoneno.text.toString()
        if(phone.length < 10){
            return "Minimum 10 Number"
        }

        if(!phone.matches(".*[0-9].*".toRegex())){
            return "Enter only a number"
        }
        if(!phone.matches(".*[A-Z].*".toRegex())){
            return "Enter only a number"
        }

        if(!phone.matches(".*[a-z].*".toRegex())){
            return "Enter only a number"
        }

        if(!phone.matches(".*[!@#$%^&*].*".toRegex())){
            return "Enter only a number"
        }
        return null
    }

    private fun validPassword(): String? {

        val password = binding.passwordid.text.toString()
        if(password.length < 8){
            return "Minimum 8 character"
        }

        if(!password.matches(".*[A-Z].*".toRegex())){
            return "Must contains 1 uppercase character"
        }

        if(!password.matches(".*[a-z].*".toRegex())){
            return "Must contains 1 lowercase character"
        }

        if(!password.matches(".*[!@#$%^&*].*".toRegex())){
            return "Must contains 1 special character"
        }
        return null
    }

    private fun validEmail(): String? {

        val email = binding.emailid.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return "Invalid email"
        }
        return null
    }





}