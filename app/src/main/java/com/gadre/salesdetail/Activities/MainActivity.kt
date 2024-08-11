package com.gadre.salesdetail.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.gadre.salesdetail.R
import com.gadre.salesdetail.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragmentContainer)

        // Initialize BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomMenu)

        // Setup NavigationUI with BottomNavigationView and NavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }
}