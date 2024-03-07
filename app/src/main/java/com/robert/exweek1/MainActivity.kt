package com.robert.exweek1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.robert.exweek1.databinding.ActivityMainBinding
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fungsi nav controller untuk membuat backstack clean :  kalau tombol back dipencet, maka stack teratas didestroy
        //kalau gak pake nav controller nanti numpuk stacknya
        //setup nav controller
        navController = (supportFragmentManager.findFragmentById(R.id.navHost) as
                NavHostFragment).navController
        //menyerahkan action bar diatas dihandle sama android
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)

        //nav controller menghandle nav view
        NavigationUI.setupWithNavController(binding.navView, navController)
        //menyerahkan nav controller handle bottonNav (gausah koding2 aneh2)
        binding.bottomNav.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
        return NavigationUI.navigateUp(navController, binding.drawerLayout) || super.onSupportNavigateUp()
    }

}