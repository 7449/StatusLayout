package com.android.status.layout

import android.view.Gravity
import android.view.View
import android.widget.FrameLayout

/**
 * @author y
 * @create 2019/3/12
 */
internal object StatusX {
    fun defaultParams(): FrameLayout.LayoutParams = FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.MATCH_PARENT,
        FrameLayout.LayoutParams.MATCH_PARENT,
        Gravity.CENTER
    )

    fun View?.statusShow() {
        this?.let {
            if (it.visibility == View.GONE) {
                it.visibility = View.VISIBLE
            }
        }
    }

    fun View?.statusHide() {
        this?.let {
            if (it.visibility == View.VISIBLE) {
                it.visibility = View.GONE
            }
        }
    }
}