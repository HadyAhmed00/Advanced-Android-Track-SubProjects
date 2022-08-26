package com.example.android.trackmysleepquality.sleeptracker

import android.graphics.Color
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter : RecyclerView.Adapter<TextItemViewHolder>() {

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
//        TODO("Not yet implemented")
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view,parent,false) as TextView
        return TextItemViewHolder(view)
    }


    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
//        TODO("Not yet implemented")
        val item = data[position]
        if(item.quality<1){
            holder.textView.setTextColor(Color.RED)
        }else if(item.quality >=4){
            holder.textView.setTextColor(Color.GREEN)

        }
        else{
            holder.textView.setTextColor(Color.BLACK)
        }

        holder.textView.text = item.quality.toString()

    }

    override fun getItemCount(): Int {
        return data.count()
    }
}
class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

