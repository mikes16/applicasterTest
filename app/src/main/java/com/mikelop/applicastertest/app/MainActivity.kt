package com.mikelop.applicastertest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.mikelop.applicastertest.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = resources.getString(R.string.feed_title)
    }

    fun showNavBar(shouldShow: Boolean = true)=
        if(shouldShow) supportActionBar?.show() else supportActionBar?.hide()
}
