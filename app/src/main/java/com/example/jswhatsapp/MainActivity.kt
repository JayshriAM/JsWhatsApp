package com.example.jswhatsapp

import android.app.ActivityGroup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TabHost
import com.example.jswhatsapp.activities.CallsActivity
import com.example.jswhatsapp.activities.ChatsActivity
import com.example.jswhatsapp.activities.StatusActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ActivityGroup() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {view ->
            Snackbar.make(view, "Contacts sync in process..", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }

        tabHost.setup(getLocalActivityManager())

        //tab 1
        var spec : TabHost.TabSpec = tabHost.newTabSpec("One")
        spec.setIndicator("CHATS")
        val intent1 = Intent(this@MainActivity, ChatsActivity::class.java)
        spec.setContent(intent1)
        tabHost.addTab(spec)

        //tab 2
        spec = tabHost.newTabSpec("Two")
        spec.setIndicator("STATUS")
        val intent2 = Intent(this@MainActivity, StatusActivity::class.java)
        spec.setContent(intent2)
        tabHost.addTab(spec)

        //tab 3
        spec = tabHost.newTabSpec("Three")
        spec.setIndicator("CALLS")
        val intent3 = Intent(this@MainActivity, CallsActivity::class.java)
        spec.setContent(intent3)
        tabHost.addTab(spec)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

}
