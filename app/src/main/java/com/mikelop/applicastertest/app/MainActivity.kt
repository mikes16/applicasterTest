package com.mikelop.applicastertest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikelop.applicastertest.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
