package com.example.fountainpencollection

import android.media.Image
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.widget.RatingBar
import android.widget.Switch
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
    private lateinit var PenImageIDTextView : Image
    private lateinit var RatingTextView : RatingBar
    private lateinit var DescriptionTextView : TextView
    private lateinit var BodyMateralTextView : TextView
    private lateinit var ColorTextView : TextView
    private lateinit var NibColorTextView : TextView
    private lateinit var NibMaterialTextView : TextView
    private lateinit var DiameterBodyTextView : TextView
    private lateinit var DiameterCapWOClipTextView : TextView
    private lateinit var DiameterCapWClipTextView : TextView
    private lateinit var DiameterGripTextView : TextView
    private lateinit var LengthBodyTextView : TextView
    private lateinit var LengthCapTextView : TextView
    private lateinit var LengthNibTextView : TextView
    private lateinit var LengthOveralCloseTextView : TextView
    private lateinit var LengthOveralPostTextView : TextView
    private lateinit var WeightBodyTextView : TextView
    private lateinit var WeightCapTextView : TextView
    private lateinit var WeightOverallTextView : TextView
    private lateinit var Favone:Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pen_view_data)

        PenNameTextView = findViewById<TextView>(R.id.PenNameDTextView)
        CompanyTextView = findViewById<TextView>(R.id.CompanyDTextView)
        PenYearTextView = findViewById<TextView>(R.id.PenYearDTextView)
        RatingTextView = findViewById<RatingBar>(R.id.PenDRatingBar)
        DescriptionTextView = findViewById<TextView>(R.id.DescriptionDTextView)
        BodyMateralTextView = findViewById<TextView>(R.id.BodyMateralDTextView)
        ColorTextView = findViewById<TextView>(R.id.ColorDTextView)
        NibColorTextView = findViewById<TextView>(R.id.NibColorDTextView)
        NibMaterialTextView = findViewById<TextView>(R.id.NibMaterialDTextView)
        DiameterBodyTextView = findViewById<TextView>(R.id.DiameterBodyDTextView)
        DiameterCapWOClipTextView = findViewById<TextView>(R.id.DiameterCapWOClipDTextView)
        DiameterCapWClipTextView = findViewById<TextView>(R.id.DiameterCapWClipDTextView)
        DiameterGripTextView = findViewById<TextView>(R.id.DiameterGripDTextView)
        LengthBodyTextView = findViewById<TextView>(R.id.LengthBodyDTextView)
        LengthCapTextView = findViewById<TextView>(R.id.LengthCapDTextView)
        LengthNibTextView = findViewById<TextView>(R.id.LengthNibDTextView)
        LengthOveralCloseTextView = findViewById<TextView>(R.id.LengthOveralCloseDTextView)
        LengthOveralPostTextView = findViewById<TextView>(R.id.LengthOverallPostDTextView)
        WeightBodyTextView = findViewById<TextView>(R.id.WeightBodyDTextView)
        WeightCapTextView = findViewById<TextView>(R.id.WeightCapDTextView)
        WeightOverallTextView = findViewById<TextView>(R.id.WeightOverallDTextView)
        Favone = findViewById<Switch>(R.id.FavoneDSwitch)

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

                        PenNameTextView.setText("Pen Name: "+PenName)
                        CompanyTextView.setText("Company Name :" + CompanyName)
                        PenYearTextView.setText("Year of the Pen" + format.format(penYearTmp))
                        RatingTextView.rating = ratingTmp!!.toFloat()
                        DescriptionTextView.setText("Description: " + Description)
                        BodyMateralTextView.setText("Body Materal: "+BodyMateral)
                        ColorTextView.setText("Color of Pen: " +Color)
                        NibColorTextView.setText("Color of Nib: "+ NibColor)
                        NibMaterialTextView.setText("Material of Nib: "+ NibMaterial)
                        DiameterBodyTextView.setText("Diameter Body: "+ mmString(DiameterBody))
                        DiameterCapWOClipTextView.setText("Diameter cap With out clip" + mmString(DiameterCapWOClip))
                        DiameterCapWClipTextView.setText("Diameter cap with clip" + mmString(DiameterCapWClip))
                        DiameterGripTextView.setText("Diameter of Grip " + mmString(DiameterGrip))
                        LengthBodyTextView.setText("Length of Body " + mmString(LengthBody))
                        LengthCapTextView.setText("Length of cap " + mmString(LengthCap))
                        LengthNibTextView.setText("Length of Nib " + mmString(LengthNib))
                        LengthOveralCloseTextView.setText("Length of overall close " + mmString(LengthOveralClose))
                        LengthOveralPostTextView.setText("Length of overall posted " + mmString(LengthOverallPost))
                        WeightBodyTextView.setText("Body Weight: " + format.format(WeightBody) + "g")
                        WeightCapTextView.setText("Cap Weight: " + format.format(WeightCap) + "g" )
                        WeightOverallTextView.setText("Overall Weight: " + format.format(WeightOverall) + "g")

                    }
                    //PenData.add(FSData)
                    Log.d("MYDEBUG", "${document.id} => ${document.getString("name")}")
                    //RestaurantAdapter = RestaurantAdapter(RestaurantData)
                }
                // the adapter for the recycler view

            }
    }

    fun mmString(data: Double?):String{
        val output : String
        output = data.toString()+"mm"
        return output
    }
}