package com.example.fountainpencollection

import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.util.TypedValue
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.NumberFormat

class PenViewData : AppCompatActivity() {
    private lateinit var db : FirebaseFirestore

    private lateinit var PenNameTitleTextView : TextView
    private lateinit var PenNameTextView : TextView
    private lateinit var CompanyTextView : TextView
    private lateinit var PenYearTextView : TextView
    private lateinit var PenImageIDTextView : ImageView
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
    private lateinit var FavoneT:Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pen_view_data)

        //
        PenImageIDTextView = findViewById<ImageView>(R.id.PenDataImageView)
        PenNameTitleTextView = findViewById<TextView>(R.id.PenDetalTextView)
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
        FavoneT = findViewById<Switch>(R.id.FavoneDSwitch)

        val PenID: String = "PenImageID"
        val PenNameTD: String = getString(R.string.PenSortButtion)
        val CompanyNameTD: String = getString(R.string.CompanySortButtion)
        val PenYearTD: String = getString(R.string.YearSortButtion)
        val RatingTD: String = getString(R.string.RatingSortButtion)
        val DescriptionTD: String = getString(R.string.DescriptionD)
        val BodyMateralTD: String = getString(R.string.BodyMateraalD)
        val ColorTD: String = getString(R.string.ColorD)
        val NibColorTD: String = getString(R.string.NibColorD)
        val NibMaterialTD: String =getString(R.string.NibMaterialD)
        val DiameterBodyTD: String =getString(R.string.DiameterBodyD)
        val DiameterCapWOClipTD: String =getString(R.string.DiameterCapWOClipD)
        val DiameterCapWClipTD: String =getString(R.string.DiameterCapWClipD)
        val DiameterGripTD: String =getString(R.string.DiameterGripD)
        val LengthBodyTD: String =getString(R.string.LengthBodyD)
        val LengthCapTD: String =getString(R.string.LengthCapD)
        val LengthNibTD: String =getString(R.string.LengthNibD)
        val LengthOveralCloseTD: String =getString(R.string.LengthOveralCloseD)
        val LengthOveralPostTD: String =getString(R.string.LengthOveralPostD)
        val WeightBodyTD: String =getString(R.string.WeightBodyD)
        val WeightCapTD: String =getString(R.string.WeightCapD)
        val WeightOverallTD: String =getString(R.string.WeightOverallD)
        val GramesTD: String = getString(R.string.Grames)



        val format: NumberFormat = DecimalFormat("0.#")

        val sp = PreferenceManager.getDefaultSharedPreferences(this@PenViewData)
        val TextSizeTP = sp.getFloat("TextSize",1.0f)

        PenNameTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,18.0f * TextSizeTP)

        val nameOfPen =sp.getString("PenNameSelected","Error")
        Log.d("ARTHUR_DEBUG", "The pen that was slected is = " + nameOfPen)

        var IDPen = " "

        db = FirebaseFirestore.getInstance()

        val PensDB = db.collection("FountainPens")

        PensDB.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // setting the data from the doc

                    var PenName = document.getString("PenName")
                    if(nameOfPen == PenName){

                        var PenID = document.getString("PenImageID")
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
                        var Favone = document.getBoolean("Fav")

                        var test : String
                        test = "this works" + format.format(penYearTmp)
                        Log.d("Tony_DEBUG", "the pen that was slected is = " + test)

                        //image
                        var imageData = Firebase.storage.reference.child(PenID.toString() +".jpg")
                        imageData.downloadUrl.addOnSuccessListener { uri ->
                            // sets te image to imageView
                            Picasso.get().load(uri).into(PenImageIDTextView)
                        }

                        PenNameTitleTextView.setText(CompanyName + " " + PenName)
                        PenNameTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        PenNameTextView.setText(PenNameTD + ": "+PenName)
                        PenNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        CompanyTextView.setText(CompanyNameTD + ": " + CompanyName)
                        CompanyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        PenYearTextView.setText(PenYearTD + ": " + format.format(penYearTmp))
                        PenYearTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        RatingTextView.rating = ratingTmp!!.toFloat()
                        DescriptionTextView.setText(DescriptionTD + ": " + Description)
                        DescriptionTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        BodyMateralTextView.setText(BodyMateralTD + ": "+ BodyMateral)
                        BodyMateralTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        ColorTextView.setText(ColorTD + ": " + Color)
                        ColorTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        NibColorTextView.setText(NibColorTD + ": " + NibColor)
                        NibColorTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        NibMaterialTextView.setText(NibMaterialTD + ": " + NibMaterial)
                        NibMaterialTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        DiameterBodyTextView.setText(DiameterBodyTD + ": " + mmString(DiameterBody))
                        DiameterBodyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        DiameterCapWOClipTextView.setText(DiameterCapWOClipTD + ": " + mmString(DiameterCapWOClip))
                        DiameterCapWOClipTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        DiameterCapWClipTextView.setText(DiameterCapWClipTD + ": " + mmString(DiameterCapWClip))
                        DiameterCapWClipTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        DiameterGripTextView.setText(DiameterGripTD + ": " + mmString(DiameterGrip))
                        DiameterGripTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        LengthBodyTextView.setText(LengthBodyTD + ": " + mmString(LengthBody))
                        LengthBodyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        LengthCapTextView.setText(LengthCapTD + ": " + mmString(LengthCap))
                        LengthCapTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        LengthNibTextView.setText(LengthNibTD + ": " + mmString(LengthNib))
                        LengthNibTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        LengthOveralCloseTextView.setText(LengthOveralCloseTD + ": " + mmString(LengthOveralClose))
                        LengthOveralCloseTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        LengthOveralPostTextView.setText(LengthOveralPostTD + ": " + mmString(LengthOverallPost))
                        LengthOveralPostTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        WeightBodyTextView.setText(WeightBodyTD + ": " + format.format(WeightBody) + GramesTD)
                        WeightBodyTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        WeightCapTextView.setText(WeightCapTD + ": " + format.format(WeightCap) + GramesTD)
                        WeightCapTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        WeightOverallTextView.setText(WeightOverallTD + ": " + format.format(WeightOverall) + GramesTD)
                        WeightOverallTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        FavoneT.setTextSize(TypedValue.COMPLEX_UNIT_SP,14.0f * TextSizeTP)
                        IDPen = document.getId().toString()

                        // setting the switch
                        if(Favone == true) {
                            FavoneT.setChecked(true)
                        }
                        else
                            FavoneT.setChecked(false)
                    }
                    Log.d("MYDEBUG", "${document.id} => ${document.getString("name")}")

                }
            }

        FavoneT.setOnClickListener {isChecked ->
            if(FavoneT.isChecked){
                PensDB.document(IDPen).update("Fav",true)
                    .addOnSuccessListener {
                    Toast.makeText(this@PenViewData,"is a Fav",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                        Toast.makeText(this@PenViewData,"Change was not appled",Toast.LENGTH_SHORT).show()
                    }

            }
            else{

            PensDB.document(IDPen).update("Fav",false).addOnSuccessListener {
                Toast.makeText(this@PenViewData, "is not a Fav", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                Toast.makeText(this@PenViewData,"Change was not appled",Toast.LENGTH_SHORT).show()
            }
            }
        }
    }

    fun mmString(data: Double?):String{
        val output : String
        output = data.toString()+"mm"
        return output
    }


}