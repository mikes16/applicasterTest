package com.mikelop.applicastertest.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.AppBarConfiguration
import android.app.SearchManager
import android.content.Context
import android.view.View
import androidx.appcompat.widget.SearchView
import com.mikelop.applicastertest.R


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = resources.getString(R.string.feed_title)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.maxWidth = Integer.MAX_VALUE

        return true
    }

    fun showOptions(shouldShow: Boolean = true) =
        if(shouldShow) searchView.visibility = View.VISIBLE else searchView.visibility = View.GONE

    fun showNavBar(shouldShow: Boolean = true)=
        if(shouldShow) supportActionBar?.show() else supportActionBar?.hide()
}
