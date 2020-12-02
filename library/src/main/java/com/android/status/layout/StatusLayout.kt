package com.android.status.layout

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

@Deprecated("@see StatusView")
class StatusLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val NORMAL = "StatusLayout:Normal"
        const val LOADING = "StatusLayout:Loading"
        const val EMPTY = "StatusLayout:Empty"
        const val SUCCESS = "StatusLayout:Success"
        const val ERROR = "StatusLayout:Error"
    }

    var status: String = ""
        set(value) {
            if (TextUtils.equals(field, value)) {
                return
            }
            hideAllView()
            when (value) {
                NORMAL -> norMalView.statusShow()
                LOADING -> loadingView.statusShow()
                EMPTY -> emptyView.statusShow()
                SUCCESS -> successView.statusShow()
                ERROR -> errorView.statusShow()
            }
            field = value
        }

    var norMalView: View? = null
    var loadingView: View? = null
    var emptyView: View? = null
    var successView: View? = null
    var errorView: View? = null
    val currentView: View?
        get() = when (status) {
            NORMAL -> norMalView
            LOADING -> loadingView
            EMPTY -> emptyView
            SUCCESS -> successView
            ERROR -> errorView
            else -> null
        }

    var onStatusNormalClick: ((view: View) -> Unit)? = null
    var onStatusLoadingClick: ((view: View) -> Unit)? = null
    var onStatusEmptyClick: ((view: View) -> Unit)? = null
    var onStatusSuccessClick: ((view: View) -> Unit)? = null
    var onStatusErrorClick: ((view: View) -> Unit)? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StatusLayout)
        val mNormalLayoutId =
            typedArray.getResourceId(R.styleable.StatusLayout_status_normal_layout, View.NO_ID)
        val mLoadingLayoutId =
            typedArray.getResourceId(R.styleable.StatusLayout_status_loading_layout, View.NO_ID)
        val mEmptyLayoutId =
            typedArray.getResourceId(R.styleable.StatusLayout_status_empty_layout, View.NO_ID)
        val mSuccessLayoutId =
            typedArray.getResourceId(R.styleable.StatusLayout_status_success_layout, View.NO_ID)
        val mErrorLayoutId =
            typedArray.getResourceId(R.styleable.StatusLayout_status_error_layout, View.NO_ID)
        val currentStatus =
            typedArray.getString(R.styleable.StatusLayout_status_current_status)
        typedArray.recycle()
        if (mNormalLayoutId != View.NO_ID) {
            addNorMalView(mNormalLayoutId)
        }
        if (mLoadingLayoutId != View.NO_ID) {
            addLoadingView(mLoadingLayoutId)
        }
        if (mEmptyLayoutId != View.NO_ID) {
            addEmptyView(mEmptyLayoutId)
        }
        if (mSuccessLayoutId != View.NO_ID) {
            addSuccessView(mSuccessLayoutId)
        }
        if (mErrorLayoutId != View.NO_ID) {
            addErrorView(mErrorLayoutId)
        }
        currentStatus?.let { status = it }
    }

    internal fun addViewDone(status: String, view: View?, layoutParams: LayoutParams?) {
        when (status) {
            NORMAL -> {
                norMalView?.let {
                    this@StatusLayout.removeView(it)
                    norMalView = null
                }
                norMalView = view
                norMalView?.setOnClickListener { v -> onStatusNormalClick?.invoke(v) }
            }
            LOADING -> {
                loadingView?.let {
                    this@StatusLayout.removeView(it)
                    loadingView = null
                }
                loadingView = view
                loadingView?.setOnClickListener { v -> onStatusLoadingClick?.invoke(v) }
            }
            SUCCESS -> {
                successView?.let {
                    this@StatusLayout.removeView(it)
                    successView = null
                }
                successView = view
                successView?.setOnClickListener { v -> onStatusSuccessClick?.invoke(v) }
            }
            ERROR -> {
                errorView?.let {
                    this@StatusLayout.removeView(it)
                    errorView = null
                }
                errorView = view
                errorView?.setOnClickListener { v -> onStatusErrorClick?.invoke(v) }
            }
            EMPTY -> {
                emptyView?.let {
                    this@StatusLayout.removeView(it)
                    emptyView = null
                }
                emptyView = view
                emptyView?.setOnClickListener { v -> onStatusEmptyClick?.invoke(v) }
            }
        }
        if (layoutParams != null) {
            addView(view, layoutParams)
        } else {
            addView(view)
        }
    }

}

