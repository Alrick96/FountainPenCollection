package com.example.fountainpencollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class AppSettingsMenu : AppCompatActivity() {
    lateinit var SwitchMode:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_settings_menu)

        SwitchMode = findViewById<TextView>(R.id.ModeTextView)

        val themSwitch=findViewById<Switch>(R.id.ThemChangeSwitch)

        themSwitch.setOnClickListener{isChecked ->

            if(themSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        //change size of text
        //change them

    }
}