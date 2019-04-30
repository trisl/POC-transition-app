package com.tristanroussel.transitionanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFirstFragment()
    }

    private fun showFirstFragment() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.main_view, FirstFragment())
                .commit()
    }
}
