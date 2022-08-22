package com.example.colormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.colormyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setListeners()
    }


    private fun setListeners(){
        val clickableViews: List<Int> = listOf(R.id.box_one_txt,R.id.box_tow_txt,R.id.box_tree_txt,R.id.box_four_txt,R.id.box_five_txt)
        val view = findViewById<LinearLayout>(R.id.vviieeww)
        for(item in clickableViews){

            findViewById<TextView>(item).setOnClickListener{

                when (item) {

                    // Boxes using Color class colors for background
                    R.id.box_one_txt -> view.setBackgroundColor(Color.DKGRAY)
                    R.id.box_tow_txt -> view.setBackgroundColor(Color.GRAY)

                    // Boxes using Android color resources for background
                    R.id.box_tree_txt -> view.setBackgroundResource(android.R.color.holo_green_light)
                    R.id.box_four_txt -> view.setBackgroundResource(android.R.color.holo_green_dark)
                    R.id.box_five_txt -> view.setBackgroundResource(android.R.color.holo_green_light)

                    else -> view.setBackgroundColor(Color.LTGRAY)
                }
            }
        }
    }


    private
    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_txt -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_tow_txt -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_tree_txt -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_txt -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_txt -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}