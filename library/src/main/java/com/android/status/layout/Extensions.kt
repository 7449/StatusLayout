@file:JvmName("StatusLayoutExtensions")
@file:Suppress("FunctionName")

package com.android.status.layout

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes

/**
 * 默认的[FrameLayout.LayoutParams]
 */
val defaultLayoutParams: FrameLayout.LayoutParams
    get() = FrameLayout.LayoutParams(
        FrameLayout.LayoutParams.MATCH_PARENT,
        FrameLayout.LayoutParams.MATCH_PARENT,
        Gravity.CENTER
    )

/**
 * 显示应该显示的View
 */
fun View?.statusShow() {
    if (this != null) {
        if (visibility == View.GONE) {
            visibility = View.VISIBLE
        }
    }
}

/**
 * 隐藏应该隐藏的View
 */
fun View?.statusHide() {
    if (this != null) {
        if (visibility == View.VISIBLE) {
            visibility = View.GONE
        }
    }
}

/**
 * 隐藏应该隐藏的View
 */
fun StatusLayout.hideAllView() {
    norMalView.statusHide()
    emptyView.statusHide()
    errorView.statusHide()
    successView.statusHide()
    loadingView.statusHide()
}

/**
 * 默认的[View]
 */
fun StatusLayout.viewLayout(@LayoutRes id: Int): View =
    LayoutInflater.from(context).inflate(id, this, false)

fun StatusLayout.addNorMalView(@LayoutRes normalLayoutRes: Int) = also {
    addNorMalView(normalLayoutRes, defaultLayoutParams)
}

fun StatusLayout.addLoadingView(@LayoutRes loadingLayoutRes: Int) = also {
    addLoadingView(loadingLayoutRes, defaultLayoutParams)
}

fun StatusLayout.addEmptyView(@LayoutRes emptyLayoutRes: Int) = also {
    addEmptyView(emptyLayoutRes, defaultLayoutParams)
}

fun StatusLayout.addSuccessView(@LayoutRes successLayoutRes: Int) = also {
    addSuccessView(successLayoutRes, defaultLayoutParams)
}

fun StatusLayout.addErrorView(@LayoutRes errorLayoutRes: Int) = also {
    addErrorView(errorLayoutRes, defaultLayoutParams)
}

fun StatusLayout.addNorMalView(@LayoutRes normalLayoutRes: Int, params: FrameLayout.LayoutParams?) =
    also {
        addNorMalView(viewLayout(normalLayoutRes), params)
    }

fun StatusLayout.addLoadingView(@LayoutRes loadingLayoutRes: Int, params: FrameLayout.LayoutParams?) =
    also {
        addLoadingView(viewLayout(loadingLayoutRes), params)
    }

fun StatusLayout.addEmptyView(@LayoutRes emptyLayoutRes: Int, params: FrameLayout.LayoutParams?) =
    also {
        addEmptyView(viewLayout(emptyLayoutRes), params)
    }

fun StatusLayout.addSuccessView(@LayoutRes successLayoutRes: Int, params: FrameLayout.LayoutParams?) =
    also {
        addSuccessView(viewLayout(successLayoutRes), params)
    }

fun StatusLayout.addErrorView(@LayoutRes errorLayoutRes: Int, params: FrameLayout.LayoutParams?) =
    also {
        addErrorView(viewLayout(errorLayoutRes), params)
    }

fun StatusLayout.addNorMalView(norMalView: View) = also {
    addNorMalView(norMalView, defaultLayoutParams)
}

fun StatusLayout.addLoadingView(loadingView: View) = also {
    addLoadingView(loadingView, defaultLayoutParams)
}

fun StatusLayout.addEmptyView(emptyView: View) = also {
    addEmptyView(emptyView, defaultLayoutParams)
}

fun StatusLayout.addSuccessView(successView: View) = also {
    addSuccessView(successView, defaultLayoutParams)
}

fun StatusLayout.addErrorView(errorView: View) = also {
    addErrorView(errorView, defaultLayoutParams)
}

fun StatusLayout.addNorMalView(norMalView: View, params: FrameLayout.LayoutParams?) = also {
    addViewDone(StatusLayout.NORMAL, norMalView, params)
}

fun StatusLayout.addLoadingView(loadingView: View, params: FrameLayout.LayoutParams?) = also {
    addViewDone(StatusLayout.LOADING, loadingView, params)
}

fun StatusLayout.addEmptyView(emptyView: View, params: FrameLayout.LayoutParams?) = also {
    addViewDone(StatusLayout.EMPTY, emptyView, params)
}

fun StatusLayout.addSuccessView(successView: View, params: FrameLayout.LayoutParams?) = also {
    addViewDone(StatusLayout.SUCCESS, successView, params)
}

fun StatusLayout.addErrorView(errorView: View, params: FrameLayout.LayoutParams?) = also {
    addViewDone(StatusLayout.ERROR, errorView, params)
}

fun StatusLayout.OnErrorClick(click: (view: View) -> Unit) = also {
    onStatusErrorClick = click
}

fun StatusLayout.OnSuccessClick(click: (view: View) -> Unit) = also {
    onStatusSuccessClick = click
}

fun StatusLayout.OnNormalClick(click: (view: View) -> Unit) = also {
    onStatusNormalClick = click
}

fun StatusLayout.OnLoadingClick(click: (view: View) -> Unit) = also {
    onStatusLoadingClick = click
}

fun StatusLayout.OnEmptyClick(click: (view: View) -> Unit) = also {
    onStatusEmptyClick = click
}

fun StatusLayout.setStatus(status: String) = also {
    this.status = status
}