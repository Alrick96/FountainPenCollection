package com.example.fountainpencollection

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button

class SortingPensMenu : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorting_pens_menu)

        var PenNameButton = findViewById(R.id.PenNameSortButton) as Button
        var CompanyNameButton = findViewById(R.id.CompanyNameSortButton) as Button
        var YearButton = findViewById(R.id.YearSortButton) as Button
        var RatingButton = findViewById(R.id.RattingSortButton) as Button

        PenNameButton.setOnClickListener{
            val context: Context = this@SortingPensMenu
            val sp = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sp.edit()
            editor.putFloat("PenNameSort",1f)
            editor.putFloat("CompanyNameSort",0f)
            editor.putFloat("YearSort",0f)
            editor.putFloat("RatingSort",0f)
            editor.apply()
            finish()
        }
        CompanyNameButton.setOnClickListener{
            val context: Context = this@SortingPensMenu
            val sp = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sp.edit()
            editor.putFloat("PenNameSort",0f)
            editor.putFloat("CompanyNameSort",1f)
            editor.putFloat("YearSort",0f)
            editor.putFloat("RatingSort",0f)
            editor.apply()
            finish()
        }
        YearButton.setOnClickListener{
            val context: Context = this@SortingPensMenu
            val sp = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sp.edit()
            editor.putFloat("PenNameSort",0f)
            editor.putFloat("CompanyNameSort",0f)
            editor.putFloat("YearSort",1f)
            editor.putFloat("RatingSort",0f)
            editor.apply()
            finish()
        }
        RatingButton.setOnClickListener{
            val context: Context = this@SortingPensMenu
            val sp = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sp.edit()
            editor.putFloat("PenNameSort",0f)
            editor.putFloat("CompanyNameSort",0f)
            editor.putFloat("YearSort",0f)
            editor.putFloat("RatingSort",1f)
            editor.apply()
            finish()
        }

    }
}