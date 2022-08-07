package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.aboutmeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var b = ActivityMainBinding.inflate(layoutInflater)

        setContentView(b.root)

//        var done_btn=b.button
//        var nikname= b.editTextTextPersonName
//        var name_txt=b.textView4
        b.button.setOnClickListener{

            var hide = b.textView4.visibility
            var show = b.button.visibility

            b.textView4.setText(b.editTextTextPersonName.text.toString())
            b.textView4.visibility=show
            b.button.visibility=hide
            b.editTextTextPersonName.visibility= hide

        }
    }



}