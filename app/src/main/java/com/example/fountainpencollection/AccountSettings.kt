package com.example.fountainpencollection

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class AccountSettings : AppCompatActivity() {
    lateinit var NewPassword : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)

        var user = FirebaseAuth.getInstance().currentUser

        var PasswordButton = findViewById(R.id.PasswordButton) as Button

        PasswordButton.setOnClickListener{

            NewPassword = findViewById(R.id.NewTextPassword)
            var newPasswordSet = NewPassword.text.toString()
            user!!.updatePassword(newPasswordSet).addOnCompleteListener { task->
                if (task.isSuccessful){
                    Toast.makeText(this@AccountSettings,"Password have been reset",Toast.LENGTH_SHORT).show()
                    finish()
                }
                else{
                    Toast.makeText(this@AccountSettings,"it has failed",Toast.LENGTH_SHORT).show()
                }
            }

        }



    }







}