package com.example.fountainpencollection

import android.content.Context
import android.content.Intent
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class PenAdapter (private var PenList:List<Pens>)
    : RecyclerView.Adapter<PenAdapter.PenViewHolder>(){

    private lateinit var listener: PenNameAdapterLisener

    inner class PenViewHolder (itemView: View):RecyclerView.ViewHolder(itemView)
    {

            val PenNameTextView: TextView = itemView.findViewById(R.id.PenNameTextView)
            val CompanyNameTextView: TextView = itemView.findViewById(R.id.CompanyNameTextView)
            val PenYearTextView: TextView = itemView.findViewById(R.id.PenYearTextView)
            val PenRating: RatingBar = itemView.findViewById(R.id.PenRatingBar)
            val context = this@PenAdapter

        init {
            itemView.setOnClickListener {
                if (listener != null) {
                    var position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onClick(position)
                    }
                }
            } // end setOnClickListener
        } // end init

        // need to implement all them
    }
    fun setOnItemClickListener(_lisener: PenNameAdapterLisener)
    {
        listener=_lisener
    }
    fun setData(List1: List<Pens>){
        PenList = List1

        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.pen_recyclerview, parent, false)

        return PenViewHolder(view)

    }

    override fun getItemCount(): Int {
        return PenList.size
    }

    override fun onBindViewHolder(holder: PenViewHolder, position: Int) {
        val PenName = PenList[position].getName()
        val CompanyName = PenList[position].getCompany()
        val PenYear = PenList[position].getPenYear()
        val PenRating = PenList[position].getRating().toFloat()

        holder.PenNameTextView.text = PenName
        holder.CompanyNameTextView.text = CompanyName
        holder.PenYearTextView.text = String.format("%.0f",PenYear)
        holder.PenRating.rating = PenRating

    }

    interface PenNameAdapterLisener{
        fun onClick(position: Int)
    }
}