# StatusLayout

Android StatusLayout

## StatusView

see demo:

[StatusViewActivity](./app/src/main/java/com/android/statuslayout/sample/StatusViewActivity.kt)

## description

    val statusView = StatusView(context)
    statusView.addView(Status(Status.ERROR,statusView.createView(R.layout.status_view_layout)))
    statusView.addView(Status(CUSTOM,statusView.createView(R.layout.status_view_layout)))
    statusView.show(Status.ERROR) 
    statusView.show(CUSTOM)
    
## activity

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val statusView = Status.bind(this)
    }
    
## click

    statusView.onClick(status) { view ->
    }
    
## currentView

    statusView.currentView

## screenshot

![](https://github.com/7449/StatusLayout/blob/master/screenshot/statuslayout.gif)

## Gradle

    implementation "com.ydevelop:status-layout:1.0.0"

## attr

    <resources>
        <declare-styleable name="StatusLayout">
            <attr name="status_error_layout" format="reference"/>
            <attr name="status_success_layout" format="reference"/>
            <attr name="status_empty_layout" format="reference"/>
            <attr name="status_loading_layout" format="reference"/>
            <attr name="status_normal_layout" format="reference"/>
            <attr name="status_current_status" format="string"/>
        </declare-styleable>
        <string name="status_error">StatusLayout:Error</string>
        <string name="status_empty">StatusLayout:Empty</string>
        <string name="status_loading">StatusLayout:Loading</string>
        <string name="status_success">StatusLayout:Success</string>
        <string name="status_normal">StatusLayout:Normal</string>
    </resources>