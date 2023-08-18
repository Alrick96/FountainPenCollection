package com.example.fountainpencollection

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView

class SortingPensMenu : AppCompatActivity() {
    lateinit var SortByTitle:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sorting_pens_menu)

        val sp = PreferenceManager.getDefaultSharedPreferences(this@SortingPensMenu)
        val TextSizeTP = sp.getFloat("TextSize",1.0f)

        SortByTitle = findViewById(R.id.SortingTitleText)
        SortByTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f * TextSizeTP)

        var PenNameButton = findViewById(R.id.PenNameSortButton) as Button
        PenNameButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
        var CompanyNameButton = findViewById(R.id.CompanyNameSortButton) as Button
        CompanyNameButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
        var YearButton = findViewById(R.id.YearSortButton) as Button
        YearButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
        var RatingButton = findViewById(R.id.RattingSortButton) as Button
        RatingButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)

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