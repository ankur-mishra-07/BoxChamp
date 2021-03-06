package com.example.boxchamp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boxchamp.R
import kotlinx.android.synthetic.main.vertical_recycler.view.*

class VerticalGameListAdapter : RecyclerView.Adapter<VerticalGameListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vertical_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 40
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = "Vertical"
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.textView
    }
}