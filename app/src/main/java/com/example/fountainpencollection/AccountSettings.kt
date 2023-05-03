package com.example.fountainpencollection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class AccountSettings : AppCompatActivity() {
    lateinit var FB:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)

        var user = FirebaseAuth.getInstance().currentUser
        var NewPassword = "fsfvsdfv"

        user!!.updatePassword(NewPassword).addOnCompleteListener { task->
            if (task.isSuccessful){

            }
            else{

            }
        }

    }







}