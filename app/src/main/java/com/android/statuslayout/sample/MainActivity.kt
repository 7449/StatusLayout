package com.android.statuslayout.sample

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.status.layout.*
import com.android.statuslayout.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val statusLayout by lazy {
        binding.statusRootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        statusLayout.status = StatusLayout.SUCCESS
        statusLayout.onStatusEmptyClick = {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
        }

        statusLayout.onStatusErrorClick = { }
        statusLayout.onStatusLoadingClick = { }
        statusLayout.onStatusNormalClick = { }
        statusLayout.onStatusSuccessClick = { }

        statusLayout.apply {
            onStatusEmptyClick = {}
            onStatusErrorClick = {}
            onStatusLoadingClick = {}
            onStatusNormalClick = {}
            onStatusSuccessClick = {}
        }

        statusLayout
            .OnEmptyClick { Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show() }
            .OnErrorClick { Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show() }
            .OnLoadingClick { Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show() }
            .OnNormalClick { Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show() }
            .OnSuccessClick {
                startActivity(Intent(this, StatusViewActivity::class.java))
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.status_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        statusLayout.status = item.title.toString()
        statusLayout.setStatus(item.title.toString())
        return true
    }

}
