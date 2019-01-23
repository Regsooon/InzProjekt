package com.tregula.graedukacyjna.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.tregula.graedukacyjna.R
import com.tregula.graedukacyjna.domain.view.data.ExternalLink

class WebBrowserFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var toolbar: Toolbar

    private lateinit var title: String
    private lateinit var url: String

    companion object {
        private const val ARG_URL = "arg_url"
        private const val ARG_TITLE = "arg_title"

        fun newInstance(externalLink: ExternalLink): WebBrowserFragment {
            val bundle = Bundle().apply {
                putString(ARG_URL, externalLink.url)
                putString(ARG_TITLE, externalLink.title)
            }

            return WebBrowserFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = arguments?.getString(ARG_TITLE).orEmpty()
        url = arguments?.getString(ARG_URL).orEmpty()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.web_view)
        toolbar = view.findViewById(R.id.toolbar)

        setupUi()
        setupWebView()
    }

    private fun setupWebView() {
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }

    private fun setupUi() {
        toolbar.title = title
    }
}