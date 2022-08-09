package com.example.trivialappme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.trivialappme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dorwlayout:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dorwlayout = binding.dragLayout
//        var id : Int = R.id.myNaveContrloer
        val navController = this.findNavController(R.id.myNaveContrloer)
        NavigationUI.setupActionBarWithNavController(this, navController,dorwlayout)
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
            if (nd.id == nc.graph.startDestinationId) {
                dorwlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                dorwlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNaveContrloer)
        return NavigationUI.navigateUp(navController,dorwlayout )
    }


}