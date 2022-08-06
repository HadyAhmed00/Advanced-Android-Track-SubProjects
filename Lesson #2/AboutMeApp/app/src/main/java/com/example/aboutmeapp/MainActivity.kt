package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var done_btn:Button = findViewById(R.id.button)
        var nikname:EditText= findViewById(R.id.editTextTextPersonName)
        var name_txt:TextView= findViewById(R.id.textView4)
        done_btn.setOnClickListener{

            var hide = name_txt.visibility
            var show = done_btn.visibility

            name_txt.setText(nikname.text.toString())
            name_txt.visibility=show
            done_btn.visibility=hide
            nikname.visibility= hide

        }
    }



}