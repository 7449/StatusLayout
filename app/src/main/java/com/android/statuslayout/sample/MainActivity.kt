package com.android.statuslayout.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.android.status.layout.StatusLayout
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var statusLayout: StatusLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        statusLayout = findViewById(R.id.status_root_view)
//        statusLayout.addSuccessView(StatusLayout(this))
//        statusLayout.status = StatusLayout.LOADING
        statusLayout.onStatusEmptyClick = {
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show()
        }
        statusLayout.onStatusErrorClick = { }
        statusLayout.onStatusLoadingClick = { }
        statusLayout.onStatusNormalClick = { }
        statusLayout.onStatusSuccessClick = { }
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
