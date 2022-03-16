package com.github.webview.test

import android.app.ActivityManager
import android.content.Context
import java.util.*

object MemoryTest {

    private val history = LinkedList<Long>()

    fun getSysMemoryInfo(context: Context): String {

        val memoryInfo = ActivityManager.MemoryInfo()

        val activityManager =
            context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(memoryInfo)
        val last = if (history.isEmpty()) {
            0L
        } else {
            history.last
        }
        val availMem = memoryInfo.availMem
        history.add(availMem)
        val change = last - availMem

        return android.text.format.Formatter.formatFileSize(context, change);
    }
}