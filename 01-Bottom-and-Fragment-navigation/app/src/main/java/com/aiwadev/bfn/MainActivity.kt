package com.aiwadev.bfn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting the nav host fragment
        appNavController = findNavController(R.id.navHostFragment)

        // Getting reference of different fragment present into our navigation
        val appConfig = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.chatFragment,
                R.id.archiveFragment
            )
        )

        // Linking nav controller to the navigation menu
        bottomNavigationView.setupWithNavController(appNavController)
        // Setting up everything
        setupActionBarWithNavController(appNavController, appConfig)
    }

    // Overriding onSupport
    override fun onSupportNavigateUp(): Boolean {
        return appNavController.navigateUp() || super.onSupportNavigateUp()
    }
}