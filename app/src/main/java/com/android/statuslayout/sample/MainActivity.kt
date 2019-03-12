package com.android.statuslayout.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.status.layout.SimpleOnStatusClickListener
import com.android.status.layout.StatusLayout

class MainActivity : AppCompatActivity() {

    private lateinit var statusLayout: StatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusLayout = findViewById(R.id.status_root_view)
//        statusLayout.addSuccessView(StatusLayout(this))
        statusLayout.onStatusClickListener = object : SimpleOnStatusClickListener() {
            override fun onStatusEmptyClick(view: View) {
                super.onStatusEmptyClick(view)
            }

            override fun onStatusErrorClick(view: View) {
                super.onStatusErrorClick(view)
            }
        }
//        statusLayout.status = StatusLayout.LOADING
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.status_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        statusLayout.status = item.title.toString()
        return true
    }

}
