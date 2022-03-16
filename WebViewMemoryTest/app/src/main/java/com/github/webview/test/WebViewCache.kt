package com.github.webview.test

import android.content.Context
import android.webkit.WebView
import java.util.concurrent.LinkedBlockingDeque

object WebViewCache {

    private val cache = LinkedBlockingDeque<WebView>()

    fun add(context: Context) {
        cache.add(WebView(context).apply {
            loadUrl("https://www.google.com.")
        })
    }

    fun remove() {
        if (cache.isNotEmpty()) {
            val webView = cache.pop()
            webView.destroy()
        }
    }
}