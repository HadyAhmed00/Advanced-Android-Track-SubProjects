package com.example.trivialappme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var naveControler= this.findNavController(R.id.hostFragment)
//        NavigationUI.setupActionBarWithNavController(this,naveControler)

    }



    override fun onSupportNavigateUp(): Boolean {
//        var navControle = this.findNavController(R.id.hostFragment)
//        return navControle.navigateUp()
        return super.onSupportNavigateUp()

    }
}