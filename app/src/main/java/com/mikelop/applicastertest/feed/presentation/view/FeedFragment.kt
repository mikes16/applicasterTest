package com.mikelop.applicastertest.feed.presentation.view

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.common.Failure
import com.mikelop.applicastertest.common.baseviews.KoinFragment
import com.mikelop.applicastertest.common.extensions.isNull
import com.mikelop.applicastertest.feed.di.feedModules
import com.mikelop.applicastertest.feed.di.feedRepositoryModules
import com.mikelop.applicastertest.feed.presentation.adapter.FeedEntriesAdapter
import com.mikelop.applicastertest.feed.presentation.entities.Entry
import com.mikelop.applicastertest.feed.presentation.viewModel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.module.Module


/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : KoinFragment() {

    private val feedViewModel by viewModel<FeedViewModel>()
    private lateinit var mAdapter: FeedEntriesAdapter
    lateinit var searchView: SearchView

    // Load Koin Modules and set the LayoutView
    override fun getModules(): List<Module> = arrayListOf(feedModules, feedRepositoryModules)
    override val layout = R.layout.fragment_feed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onStart() {
        super.onStart()

        // Observers
        feedViewModel.failure.observe(viewLifecycleOwner, onErrorOccurred)
        feedViewModel.entries.observe(viewLifecycleOwner, onEntriesRetrieved)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_main, menu)

        // Associate searchable configuration with the SearchView
        val searchManager = activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)?.actionView as SearchView
        val iconSearch = searchView.findViewById<ImageView>(R.id.search_button)
        val iconClose = searchView.findViewById<ImageView>(R.id.search_close_btn)
        iconSearch.setColorFilter(Color.WHITE)
        iconClose.setColorFilter(Color.WHITE)
        searchView.setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
        searchView.maxWidth = Integer.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                if(::mAdapter.isInitialized) {
                    mAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                if(::mAdapter.isInitialized) {
                    mAdapter.filter.filter(query)
                }
                return false
            }
        })
    }

    private val onEntriesRetrieved = Observer<ArrayList<Entry>> {
        if(feed_rv.adapter.isNull()) {
            mAdapter = FeedEntriesAdapter(it)
            feed_rv.adapter = mAdapter
        }
    }

    private val onErrorOccurred =  Observer<Failure> {
        val errorMessage = when (it){
            is Failure.NetworkConnection -> "Network Connection Error"
            is Failure.NoResponse -> "Server Not Responding"
            is Failure.ServerError -> "code: ${it.code}, message: ${it.message}"
            is Failure.FeatureFailure -> "Unexpected Error"
        }
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

}
