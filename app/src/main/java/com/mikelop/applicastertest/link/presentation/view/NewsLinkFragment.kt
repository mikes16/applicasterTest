package com.mikelop.applicastertest.link.presentation.view

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.mikelop.applicastertest.R
import com.mikelop.applicastertest.common.baseviews.KoinFragment
import kotlinx.android.synthetic.main.fragment_news_link.*
import kotlinx.android.synthetic.main.fragment_news_link.view.*
import org.koin.core.module.Module

/**
 * A simple [Fragment] subclass.
 */
class NewsLinkFragment : KoinFragment() {

    val args: NewsLinkFragmentArgs by navArgs()

    override fun getModules(): List<Module> = arrayListOf()
    override val layout: Int = R.layout.fragment_news_link

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.container_wv.loadUrl(args.link)
        view.container_wv.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                loader_pb.visibility = View.GONE
            }


        }
    }



}
