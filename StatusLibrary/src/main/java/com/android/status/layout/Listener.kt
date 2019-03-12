package com.android.status.layout

import android.view.View

/**
 * @author y
 * @create 2019/3/12
 */
interface OnStatusClickListener {
    fun onStatusNorMalClick(view: View)
    fun onStatusLoadingClick(view: View)
    fun onStatusEmptyClick(view: View)
    fun onStatusSuccessClick(view: View)
    fun onStatusErrorClick(view: View)
}


open class SimpleOnStatusClickListener : OnStatusClickListener {
    override fun onStatusNorMalClick(view: View) {}
    override fun onStatusLoadingClick(view: View) {}
    override fun onStatusEmptyClick(view: View) {}
    override fun onStatusSuccessClick(view: View) {}
    override fun onStatusErrorClick(view: View) {}
}
