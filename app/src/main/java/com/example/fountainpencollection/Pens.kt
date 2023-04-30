package com.example.fountainpencollection

class Pens (private var PenName:String,
            private var Company:String,
            private var PenYear:Double,
            private var PenImageID:String,
            private var Rating:Double,
            private var Description:String,
            private var BodyMateral:String,
            private var Color:String,
            private var NibColor:String,
            private var NibMaterial:String,
            private var DiameterBody:Double,
            private var DiameterCapWOClip:Double,
            private var DiameterCapWClip:Double,
            private var DiameterGrip:Double,
            private var LengthBody:Double,
            private var LengthCap:Double,
            private var LengthNib:Double,
            private var LengthOveralClose:Double,
            private var LengthOverallPost:Double,
            private var WeightBody:Double,
            private var WeightCap:Double,
            private var WeightOverall:Double,
            private var Favone:Boolean){

    fun getName():String{
        return PenName
    }
    fun getCompany():String{
        return Company
    }
    fun getPenYear():Double{
        return PenYear
    }
    fun getPenImageID():String{
        return PenImageID
    }
    fun getRating():Double{
        return Rating
    }
    fun getDescription():String{
        return Description
    }
    fun getBodyMateral():String{
        return BodyMateral
    }
    fun getColor():String{
        return Color
    }
    fun getNibColor():String{
        return NibColor
    }
    fun getNibMaterial():String{
        return NibMaterial
    }
    fun getDiameterBody():Double{
        return DiameterBody
    }
    fun getDiameterCapWOClip():Double{
        return DiameterCapWOClip
    }
    fun getDiameterCapWClip():Double{
        return DiameterCapWClip
    }
    fun getDiameterGrip():Double{
        return DiameterGrip
    }
    fun getLengthBody():Double{
        return LengthBody
    }
    fun getLengthCap():Double{
        return LengthCap
    }
    fun getLengthNib():Double{
        return LengthNib
    }
    fun getLengthOveralClose():Double{
        return LengthOveralClose
    }
    fun getLengthOverallPost():Double{
        return LengthOverallPost
    }
    fun getWeightBody():Double{
        return WeightBody
    }
    fun getWeightCap():Double{
        return WeightCap
    }
    fun getWeightOverall():Double{
        return WeightOverall
    }
    fun getFav():Boolean{
        return Favone
    }
}