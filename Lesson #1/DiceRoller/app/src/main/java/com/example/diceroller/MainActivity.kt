package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollBotton: Button = findViewById(R.id.roll_btn );

        rollBotton.setOnClickListener{
            rollDice()

        }
    }
    fun rollDice(){

        var a = Random().nextInt(6)+1;
        var num_text:TextView = findViewById(R.id.number_txt );
        num_text.setText(a.toString() );
        var img : ImageView = findViewById(R.id.dice_img  )
        when (a) {
            1 -> {
                img.setImageResource(R.drawable.dice_1)
            }
            2 -> {
                img.setImageResource(R.drawable.dice_2)
            }
            3 -> {
                img.setImageResource(R.drawable.dice_3)
            }
            4 -> {
                img.setImageResource(R.drawable.dice_4)
            }
            5 -> {
                with(img) { setImageResource(R.drawable.dice_5) }
            }
            6 -> {
                img.setImageResource(R.drawable.dice_6)
            }
        }


    }
}