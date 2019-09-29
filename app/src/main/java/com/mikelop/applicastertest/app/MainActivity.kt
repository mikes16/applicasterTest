package com.mikelop.applicastertest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mikelop.applicastertest.R
import org.json.JSONArray



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
