package com.example.android.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight

@BindingAdapter("sleepDuration")
fun TextView.setSleepDurationFormat(sleep : SleepNight?)
{
    sleep?.let {
        text = convertDurationToFormatted(sleep.startTime,sleep.endTime,context.resources)
    }
}

@BindingAdapter("sleepQualityText" )
fun TextView.setSleepQuality(sleep : SleepNight?){
    sleep?.let {
        text = convertNumericQualityToString(sleep.quality,context.resources)

    }
}
@BindingAdapter("sleepImage")
fun ImageView.setQualityImage(sleep: SleepNight?){
    sleep?.let {
        setImageResource(when (sleep.quality){
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_launcher_sleep_tracker_foreground
        })
    }
}