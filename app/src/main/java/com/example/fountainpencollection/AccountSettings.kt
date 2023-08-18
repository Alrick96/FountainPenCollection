package com.example.fountainpencollection

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class AccountSettings : AppCompatActivity() {
    lateinit var NewPassword : TextView
    lateinit var PasswordTitle : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)

        val sp = PreferenceManager.getDefaultSharedPreferences(this@AccountSettings)
        val TextSizeTP = sp.getFloat("TextSize",1.0f)
        NewPassword = findViewById(R.id.NewTextPassword)
        NewPassword.setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f * TextSizeTP)
        PasswordTitle = findViewById(R.id.NewPasswordTextView)
        PasswordTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f * TextSizeTP)

        var user = FirebaseAuth.getInstance().currentUser

        var PasswordButton = findViewById(R.id.PasswordButton) as Button
        PasswordButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)

        PasswordButton.setOnClickListener {
            val tester = true

            if (tester == false) {
                NewPassword = findViewById(R.id.NewTextPassword)
                var newPasswordSet = NewPassword.text.toString()
                user!!.updatePassword(newPasswordSet).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this@AccountSettings,
                            "Password have been reset",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    } else {
                        Toast.makeText(this@AccountSettings, "it has failed", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
            else
            {
                Toast.makeText(this@AccountSettings,"desabled for viewing", Toast.LENGTH_SHORT)
            }
        }
    }
}