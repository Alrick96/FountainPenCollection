package com.example.fountainpencollection

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DecimalFormat
import java.text.NumberFormat

class PenViewData : AppCompatActivity() {
    private lateinit var db : FirebaseFirestore

    private lateinit var PenNameTextView : TextView
    private lateinit var CompanyTextView : TextView
    private lateinit var PenYearTextView : TextView
    private lateinit var PenImageIDTextView : TextView
    private lateinit var RatingTextView : TextView
    private lateinit var DescriptionTextView : TextView
    private lateinit var BodyMateralTextView : TextView
    private lateinit var ColorTextView : TextView
    private lateinit var NibColorTextView : TextView
    private lateinit var NibMaterialTextView : TextView
    private lateinit var DiameterBodyTextView : TextView
    private lateinit var DiameterCapWOClipTextView : TextView
    private lateinit var DiameterGripTextView : TextView
    private lateinit var LengthBodyTextView : TextView
    private lateinit var LengthCapTextView : TextView
    private lateinit var LengthNibTextView : TextView
    private lateinit var LengthOveralCloseTextView : TextView
    private lateinit var WeightBodyTextView : TextView
    private lateinit var WeightCapTextView : TextView
    private lateinit var WeightOverallTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pen_view_data)

        val format: NumberFormat = DecimalFormat("0.#")

        val sp = PreferenceManager.getDefaultSharedPreferences(this@PenViewData)
        val nameOfPen =sp.getString("PenNameSelected","Error")
        Log.d("ARTHUR_DEBUG", "the pen that was slected is = " + nameOfPen)


        db = FirebaseFirestore.getInstance()
        val PensDB = db.collection("FountainPens")

        PensDB.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // setting the data from the doc

                    var PenName = document.getString("PenName")
                    if(nameOfPen == PenName){

                        var CompanyName = document.getString("CompanyName")
                        var penYearTmp = document.getDouble("PenYear")
                        var ratingTmp = document.getDouble("Rating")
                        var Description= document.getString("Description")
                        var BodyMateral= document.getString("BodyMateral")
                        var Color= document.getString("Color")
                        var NibColor= document.getString("NibColor")
                        var NibMaterial= document.getString("NibMaterial")
                        var DiameterBody = document.getDouble("DiameterBody")
                        var DiameterCapWOClip = document.getDouble("DiameterCapWOClip")
                        var DiameterCapWClip = document.getDouble("DiameterCapWClip")
                        var DiameterGrip = document.getDouble("DiameterGrip")
                        var LengthBody = document.getDouble("LengthBody")
                        var LengthCap = document.getDouble("LengthCap")
                        var LengthNib = document.getDouble("LengthNib")
                        var LengthOveralClose = document.getDouble("LengthOveralClose")
                        var LengthOverallPost = document.getDouble("LengthOverallPost")
                        var WeightBody = document.getDouble("WeightBody")
                        var WeightCap = document.getDouble("WeightCap")
                        var WeightOverall = document.getDouble("WeightOverall")
                        var Favone = document.getDouble("Favone")

                        var test : String
                        test = "this works" + format.format(penYearTmp)
                        Log.d("Tony_DEBUG", "the pen that was slected is = " + test)

                    }
                    //PenData.add(FSData)
                    Log.d("MYDEBUG", "${document.id} => ${document.getString("name")}")
                    //RestaurantAdapter = RestaurantAdapter(RestaurantData)
                }
                // the adapter for the recycler view

            }
    }
}