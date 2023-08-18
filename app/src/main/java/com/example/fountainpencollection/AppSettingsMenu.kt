package com.example.fountainpencollection

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.TypedValue
import android.webkit.WebSettings.TextSize
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class AppSettingsMenu : AppCompatActivity() {
    lateinit var NightModeText : TextView
    lateinit var FontChangeTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_settings_menu)

        val context: Context = this@AppSettingsMenu
        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        //val TextSizeTP = sp.getFloat("TextSize",1.0f)

        NightModeText = findViewById(R.id.ModeTextView)
        FontChangeTextView = findViewById(R.id.FontChangeTextView)

        //NightModeText.setTextSize(TypedValue.COMPLEX_UNIT_SP,TextSizeTP)
       // FontChangeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,TextSizeTP)



        val themSwitch=findViewById<Switch>(R.id.ThemChangeSwitch)

        if (StateOFNightMode() == true)
        {
            themSwitch.setChecked(true)
        }
        //checks the
        themSwitch.setOnClickListener{isChecked ->
            if(themSwitch.isChecked){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        // each buttion saves the size of the text
        var ButtonSmall = findViewById(R.id.buttonSmall) as Button
        ButtonSmall.setOnClickListener {
            val editor = sp.edit()
            editor.putFloat("TextSize",0.5f)
            editor.apply()
            onResume()
        }

        var ButtonMedium = findViewById(R.id.buttonMedium) as Button
        ButtonMedium.setOnClickListener {
            val editor = sp.edit()
            editor.putFloat("TextSize",1.0f)
            editor.apply()
            onResume() }

        var ButtonLarg = findViewById(R.id.buttonLarge) as Button
        ButtonLarg.setOnClickListener {
            val editor = sp.edit()
            editor.putFloat("TextSize",1.5f)
            editor.apply()
            onResume() }

    }

    override fun onResume() {
        super.onResume()
        TextSizeRest()
    }
    //returns if night mode is on or not
    fun StateOFNightMode():Boolean{
        return when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> true
            else -> false
        }
    }

    //on resume will implament new size of text
    fun TextSizeRest(){
        val context: Context = this@AppSettingsMenu
        val sp = PreferenceManager.getDefaultSharedPreferences(context)

        val TextSizeTP = sp.getFloat("TextSize",1.0f)

        NightModeText.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
        FontChangeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
    }
}