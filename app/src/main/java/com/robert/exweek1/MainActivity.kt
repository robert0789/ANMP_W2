package com.robert.exweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fungsi nav controller untuk membuat backstack clean :  kalau tombol back dipencet, maka stack teratas didestroy
        //kalau gak pake nav controller nanti numpuk stacknya
        //setup nav controller
        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as
                NavHostFragment).navController
        //menyerahkan action bar diatas dihandle sama android
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}