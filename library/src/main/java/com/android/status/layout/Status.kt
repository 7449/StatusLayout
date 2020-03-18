package com.android.status.layout

import android.app.Activity
import android.view.View

data class Status(
    val status: Any,
    val view: View
) {
    companion object {
        const val NORMAL = 0
        const val LOADING = 1
        const val EMPTY = 2
        const val SUCCESS = 3
        const val ERROR = 4

        fun createStatus(status: Any, view: View): Status {
            return Status(status, view)
        }

        fun bind(context: Activity): StatusView {
            val statusView = StatusView(context)
            context.setContentView(statusView)
            return statusView
        }
    }
}