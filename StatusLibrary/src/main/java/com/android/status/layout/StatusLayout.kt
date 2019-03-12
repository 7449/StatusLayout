package com.android.status.layout

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.android.status.layout.StatusX.statusHide
import com.android.status.layout.StatusX.statusShow

class StatusLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val NORMAL = "StatusLayout:Normal"
        const val LOADING = "StatusLayout:Loading"
        const val EMPTY = "StatusLayout:Empty"
        const val SUCCESS = "StatusLayout:Success"
        const val ERROR = "StatusLayout:Error"
    }

    var status: String = NORMAL
        set(value) {
            if (TextUtils.equals(field, value)) {
                return
            }
            mNorMalView.statusHide()
            mLoadingView.statusHide()
            mEmptyView.statusHide()
            mSuccessView.statusHide()
            mErrorView.statusHide()
            when (value) {
                NORMAL -> mNorMalView.statusShow()
                LOADING -> mLoadingView.statusShow()
                EMPTY -> mEmptyView.statusShow()
                SUCCESS -> mSuccessView.statusShow()
                ERROR -> mErrorView.statusShow()
            }
            field = value
        }

    var currentView: View? = null
        private set
        get() = when (status) {
            NORMAL -> mNorMalView
            LOADING -> mLoadingView
            EMPTY -> mEmptyView
            SUCCESS -> mSuccessView
            ERROR -> mErrorView
            else -> throw RuntimeException("please check status")
        }


    var onStatusClickListener: OnStatusClickListener? = null

    private var mNorMalView: View? = null
    private var mLoadingView: View? = null
    private var mEmptyView: View? = null
    private var mSuccessView: View? = null
    private var mErrorView: View? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StatusLayout)
        val mNormalLayoutId = typedArray.getResourceId(R.styleable.StatusLayout_status_normal_layout, View.NO_ID)
        val mLoadingLayoutId = typedArray.getResourceId(R.styleable.StatusLayout_status_loading_layout, View.NO_ID)
        val mEmptyLayoutId = typedArray.getResourceId(R.styleable.StatusLayout_status_empty_layout, View.NO_ID)
        val mSuccessLayoutId = typedArray.getResourceId(R.styleable.StatusLayout_status_success_layout, View.NO_ID)
        val mErrorLayoutId = typedArray.getResourceId(R.styleable.StatusLayout_status_error_layout, View.NO_ID)
        val currentStatus = typedArray.getString(R.styleable.StatusLayout_status_current_status)
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
                mNorMalView?.let {
                    this@StatusLayout.removeView(it)
                    mNorMalView = null
                }
                mNorMalView = view
                mNorMalView?.setOnClickListener { v -> onStatusClickListener?.onStatusErrorClick(v) }
            }
            LOADING -> {
                mLoadingView?.let {
                    this@StatusLayout.removeView(it)
                    mLoadingView = null
                }
                mLoadingView = view
                mLoadingView?.setOnClickListener { v -> onStatusClickListener?.onStatusLoadingClick(v) }
            }
            SUCCESS -> {
                mSuccessView?.let {
                    this@StatusLayout.removeView(it)
                    mSuccessView = null
                }
                mSuccessView = view
                mSuccessView?.setOnClickListener { v -> onStatusClickListener?.onStatusSuccessClick(v) }
            }
            ERROR -> {
                mErrorView?.let {
                    this@StatusLayout.removeView(it)
                    mErrorView = null
                }
                mErrorView = view
                mErrorView?.setOnClickListener { v -> onStatusClickListener?.onStatusErrorClick(v) }
            }
            EMPTY -> {
                mSuccessView?.let {
                    this@StatusLayout.removeView(it)
                    mSuccessView = null
                }
                mEmptyView = view
                mEmptyView?.setOnClickListener { v -> onStatusClickListener?.onStatusEmptyClick(v) }
            }
        }

        if (layoutParams != null) {
            addView(view, layoutParams)
        } else {
            addView(view)
        }
    }

}

