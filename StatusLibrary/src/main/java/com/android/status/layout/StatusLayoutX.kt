package com.android.status.layout

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import com.android.status.layout.StatusX.defaultParams

/**
 * @author y
 * @create 2019/3/12
 */

internal fun StatusLayout.viewLayout(@LayoutRes id: Int): View = LayoutInflater.from(context).inflate(id, this, false)

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