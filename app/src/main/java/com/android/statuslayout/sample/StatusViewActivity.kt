package com.android.statuslayout.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.status.layout.Status
import com.android.status.layout.StatusView

class StatusViewActivity : AppCompatActivity() {

    companion object {
        const val CUSTOM = 10
    }

    private lateinit var statusView: StatusView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "StatusView"
        statusView = Status.bind(this)
            .apply {
                addView(
                    Status(
                        Status.NORMAL,
                        view = this.createView(R.layout.layout_normal)
                    )
                )
                addView(
                    Status(
                        Status.ERROR,
                        view = this.createView(R.layout.layout_status_error)
                    )
                )
                addView(
                    Status(
                        Status.EMPTY,
                        view = this.createView(R.layout.layout_status_empty)
                    )
                )
                addView(
                    Status(
                        Status.SUCCESS,
                        view = this.createView(R.layout.layout_success)
                    )
                )
                addView(
                    Status(
                        Status.LOADING,
                        view = this.createView(R.layout.layout_status_loading)
                    )
                )
                show(Status.LOADING)
            }
        statusView.onClick(CUSTOM) {
            Toast.makeText(this, "custom", Toast.LENGTH_LONG).show()
        }
        statusView.onClick(22) {
            Toast.makeText(this, "null", Toast.LENGTH_LONG).show()
        }

        Toast.makeText(this, statusView.currentView.toString(), Toast.LENGTH_LONG).show()

        statusView.postDelayed({
            statusView.addView(
                Status(
                    CUSTOM,
                    view = statusView.createView(R.layout.layout_status_custom)
                )
            )
        }, 2000)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.status_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.normal -> statusView.show(Status.NORMAL)
            R.id.error -> statusView.show(Status.ERROR)
            R.id.empty -> statusView.show(Status.EMPTY)
            R.id.success -> statusView.show(Status.SUCCESS)
            R.id.loading -> statusView.show(Status.LOADING)
            R.id.custom -> statusView.show(CUSTOM)
        }
        return true
    }
}