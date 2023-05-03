package com.example.fountainpencollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class AppSettingsMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_settings_menu)

        val themSwitch=findViewById<Switch>(R.id.ThemChangeSwitch)

        themSwitch.setOnClickListener{isChecked ->

            if(themSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                themSwitch.text = "Disable dark mode"
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                themSwitch.text = "Enable dark mode"
            }
        }

        //change size of text
        //change them

    }
}