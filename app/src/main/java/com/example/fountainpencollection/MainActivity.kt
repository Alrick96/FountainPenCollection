package com.example.fountainpencollection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var db : FirebaseFirestore
    private lateinit var LoginDB : FirebaseAuth
    private lateinit var userNameText : EditText
    private lateinit var passwordText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = FirebaseFirestore.getInstance()
        LoginDB = FirebaseAuth.getInstance()
        var buttionLogin = findViewById(R.id.loginButton) as Button

        buttionLogin.setOnClickListener {
            userNameText = findViewById(R.id.UserNameInputText)
            passwordText = findViewById(R.id.PasswordInputText)

            var userNamedata = userNameText.text.toString()
            var passWord = passwordText.text.toString()


            LoginDB.signInWithEmailAndPassword(userNamedata,passWord).addOnCompleteListener(
                this
            ){task ->
                if (task.isSuccessful){
                    val intent = Intent(this@MainActivity,MainPenGallery::class.java)
                    startActivity(intent)
                }
                else{
                    var failMeassage=R.string.loginFail
                    Toast.makeText(this@MainActivity,failMeassage, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}