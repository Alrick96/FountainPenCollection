package com.example.fountainpencollection

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import org.checkerframework.common.returnsreceiver.qual.This

class MainPenGallery : AppCompatActivity() {

    private lateinit var PenRecyclerView: RecyclerView
    private lateinit var PenData:ArrayList<Pens>
    private lateinit var PenAdapter: PenAdapter

    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_pen_gallery)

        // recyclerView set up
        PenRecyclerView = findViewById<RecyclerView>(R.id.PenRecyclerView)
        PenRecyclerView.layoutManager = LinearLayoutManager(this)
        PenData = ArrayList<Pens>()

        PenAdapter = PenAdapter(PenData)
        PenRecyclerView.adapter = PenAdapter

        // firebase data is being loaded
        db = FirebaseFirestore.getInstance()

        val context: Context = this@MainPenGallery
        val sp = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sp.edit()
        editor.putFloat("PenNameSort",0f)
        editor.putFloat("CompanyNameSort",0f)
        editor.putFloat("YearSort",0f)
        editor.putFloat("RatingSort",0f)
        editor.apply()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.penmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            R.id.AccountSettingMenu->{
                val i = Intent(this@MainPenGallery, AccountSettings::class.java)
                startActivity(i)
                true
            }
            R.id.AppSettingMenu->{
                val i = Intent(this@MainPenGallery, AppSettingsMenu::class.java)
                startActivity(i)
                true
            }
            R.id.FavoritePensMenu->{
                val i = Intent(this@MainPenGallery,FavoritePensMenu::class.java)
                startActivity(i)
                true
            }
            R.id.SortingMenu->{
                val i = Intent(this@MainPenGallery,SortingPensMenu::class.java)
                startActivity(i)
                true
            }
            R.id.ClearSortMenu->{
                val context: Context = this@MainPenGallery
                val sp = PreferenceManager.getDefaultSharedPreferences(context)
                val editor = sp.edit()
                editor.putFloat("PenNameSort",0f)
                editor.putFloat("CompanyNameSort",0f)
                editor.putFloat("YearSort",0f)
                editor.putFloat("RatingSort",0f)

                editor.apply()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        loadFromdb()
    }

    fun loadFromdb(){
        PenData.clear()


        val sp = PreferenceManager.getDefaultSharedPreferences(this@MainPenGallery)
        //val filterState = sp.getFloat("filterState",0f)
        //val filterData= sp.getFloat("filterData",0.0f)

        db.collection("FountainPens").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // setting the data from the doc

                    var PenName = document.getString("PenName")
                    var CompanyName = document.getString("CompanyName")
                    var tmp2 = document.getDouble("PenYear")
                    var tmp1 = document.getDouble("Rating")
                    var Fav = document.getBoolean("Fav")
                    var Fav2 = Fav.toString()

                    var rating = tmp1.toString()
                    var PenYear = tmp2.toString()

                    var FSData =
                        Pens(PenName.toString(),CompanyName.toString(), PenYear.toDouble(),"0",rating.toDouble()
                        ,"","","","","",0.0,0.0,0.0,0.0
                        ,0.0,0.0,0.0,0.0,0.0,0.0,0.0,
                            0.0,Fav2.toBoolean())
                    //Log.d("MYDeBUG",name.toString())
                    //Log.d("ReturantNamedata", FSData.getName())
                    //Log.d("ReturantRatingData", FSData.getRating().toString())
                    //Log.d("ReturantNamedata", FSData.getLocation())
                    /*if (filterState != 0f) {
                        if(filterData <=  rating.toDouble()){
                            RestaurantData.add(FSData)
                        }
                    }
                    else{
                        RestaurantData.add(FSData)
                    }
                    */
                     PenData.add(FSData)
                    Log.d("MYDEBUG", "${document.id} => ${document.getString("name")}")
                    //RestaurantAdapter = RestaurantAdapter(RestaurantData)
                }
                // the adapter for the recycler view
                PenAdapter.notifyDataSetChanged()
            }
    }
}