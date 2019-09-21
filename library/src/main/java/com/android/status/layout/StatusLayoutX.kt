@file:Suppress("FunctionName")

package com.android.status.layout

import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import com.android.status.layout.StatusX.defaultParams
import com.android.status.layout.StatusX.viewLayout

/**
 * @author y
 * @create 2019/3/12
 */
fun StatusLayout.addNorMalView(@LayoutRes normalLayoutRes: Int) = addNorMalView(normalLayoutRes, defaultParams())

fun StatusLayout.addLoadingView(@LayoutRes loadingLayoutRes: Int) = addLoadingView(loadingLayoutRes, defaultParams())

fun StatusLayout.addEmptyView(@LayoutRes emptyLayoutRes: Int) = addEmptyView(emptyLayoutRes, defaultParams())

fun StatusLayout.addSuccessView(@LayoutRes successLayoutRes: Int) = addSuccessView(successLayoutRes, defaultParams())

fun StatusLayout.addErrorView(@LayoutRes errorLayoutRes: Int) = addErrorView(errorLayoutRes, defaultParams())

fun StatusLayout.addNorMalView(@LayoutRes normalLayoutRes: Int, params: FrameLayout.LayoutParams?) = addNorMalView(viewLayout(normalLayoutRes), params)

fun StatusLayout.addLoadingView(@LayoutRes loadingLayoutRes: Int, params: FrameLayout.LayoutParams?) = addLoadingView(viewLayout(loadingLayoutRes), params)

fun StatusLayout.addEmptyView(@LayoutRes emptyLayoutRes: Int, params: FrameLayout.LayoutParams?) = addEmptyView(viewLayout(emptyLayoutRes), params)

fun StatusLayout.addSuccessView(@LayoutRes successLayoutRes: Int, params: FrameLayout.LayoutParams?) = addSuccessView(viewLayout(successLayoutRes), params)

fun StatusLayout.addErrorView(@LayoutRes errorLayoutRes: Int, params: FrameLayout.LayoutParams?) = addErrorView(viewLayout(errorLayoutRes), params)

fun StatusLayout.addNorMalView(norMalView: View) = addNorMalView(norMalView, defaultParams())

fun StatusLayout.addLoadingView(loadingView: View) = addLoadingView(loadingView, defaultParams())

fun StatusLayout.addEmptyView(emptyView: View) = addEmptyView(emptyView, defaultParams())

fun StatusLayout.addSuccessView(successView: View) = addSuccessView(successView, defaultParams())

fun StatusLayout.addErrorView(errorView: View) = addErrorView(errorView, defaultParams())

fun StatusLayout.addNorMalView(norMalView: View, params: FrameLayout.LayoutParams?) = addViewDone(StatusLayout.NORMAL, norMalView, params)

fun StatusLayout.addLoadingView(loadingView: View, params: FrameLayout.LayoutParams?) = addViewDone(StatusLayout.LOADING, loadingView, params)

fun StatusLayout.addEmptyView(emptyView: View, params: FrameLayout.LayoutParams?) = addViewDone(StatusLayout.EMPTY, emptyView, params)

fun StatusLayout.addSuccessView(successView: View, params: FrameLayout.LayoutParams?) = addViewDone(StatusLayout.SUCCESS, successView, params)

fun StatusLayout.addErrorView(errorView: View, params: FrameLayout.LayoutParams?) = addViewDone(StatusLayout.ERROR, errorView, params)

fun StatusLayout.OnErrorClick(click: (view: View) -> Unit): StatusLayout {
    this.onStatusErrorClick = click
    return this
}

fun StatusLayout.OnSuccessClick(click: (view: View) -> Unit): StatusLayout {
    this.onStatusSuccessClick = click
    return this
}

fun StatusLayout.OnNormalClick(click: (view: View) -> Unit): StatusLayout {
    this.onStatusNormalClick = click
    return this
}

fun StatusLayout.OnLoadingClick(click: (view: View) -> Unit): StatusLayout {
    this.onStatusLoadingClick = click
    return this
}

fun StatusLayout.OnEmptyClick(click: (view: View) -> Unit): StatusLayout {
    this.onStatusEmptyClick = click
    return this
}

fun StatusLayout.status(status: String): StatusLayout {
    this.status = status
    return this
}

