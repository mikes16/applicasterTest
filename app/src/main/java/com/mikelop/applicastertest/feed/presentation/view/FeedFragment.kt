package com.mikelop.applicastertest.feed.presentation.view

import android.os.Bundle
import android.widget.Toast
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

    private val chatViewModel by viewModel<FeedViewModel>()

    // Load Koin Modules and set the LayoutView
    override fun getModules(): List<Module> = arrayListOf(feedModules, feedRepositoryModules)
    override val layout = R.layout.fragment_feed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        chatViewModel.getFeedLinks()
    }

    override fun onStart() {
        super.onStart()

        // Observers
        chatViewModel.failure.observe(viewLifecycleOwner, onErrorOccurred)
        chatViewModel.entries.observe(viewLifecycleOwner, onEntriesRetrieved)
    }

    private val onEntriesRetrieved = Observer<ArrayList<Entry>> {
        if(feed_rv.adapter.isNull()) {
            feed_rv.adapter = FeedEntriesAdapter(it)
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
