@file:Suppress("MemberVisibilityCanBePrivate")

package com.android.status.layout

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes

class StatusView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val TAG = "StatusView"
        private const val NO_ID = -1
    }

    private val views: ArrayList<Status> = ArrayList()

    var autoClean: Boolean = true

    fun addView(status: Status) = also {
        if (findStatus(status) != null) {
            throw RuntimeException("addView:already exists in the same state")
        }
        views.add(status)
    }

    fun removeView(status: Any) = also {
        val find = findStatus(status)
        if (find == null) {
            Log.w(TAG, "removeView:the status does not exist")
        } else {
            it.removeView(find.view)
            views.remove(status)
        }
    }

    fun show(status: Any) {
        val find = findStatus(status)
        if (find == null) {
            Log.w(TAG, "show:the status does not exist")
            return
        }
        hideAllViews()
        val indexOfChild = this.indexOfChild(find.view)
        if (indexOfChild == NO_ID) {
            addView(find.view)
        }
        find.view.statusShow()
    }

    val currentView: View?
        get() {
            if (views.filter { it.view.visibility == View.VISIBLE }.size > 1) {
                throw RuntimeException("there are two or more displayed views")
            }
            return views.find { it.view.visibility == View.VISIBLE }?.view
        }

    fun onClick(status: Any, click: (view: View) -> Unit) {
        onAttachView(status)?.let { it -> it.setOnClickListener { click.invoke(it) } }
    }

    fun clean() {
        views.clear()
        removeAllViews()
    }

    fun createView(@LayoutRes id: Int): View {
        return inflate(this.context, id, null)
    }

    private fun hideAllViews() {
        views.forEach { it.view.statusHide() }
    }

    private fun findStatus(status: Any): Status? {
        return views.find { it.status == status }
    }

    private fun onAttachView(status: Any): View? {
        val find = findStatus(status)
        if (find == null || this.indexOfChild(find.view) == NO_ID) {
            Log.w(TAG, "onAttachView:the status does not exist,find:" + find?.toString())
            return null
        }
        return find.view
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (autoClean) {
            clean()
        }
    }

}