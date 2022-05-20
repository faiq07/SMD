package com.example.testdemo

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class Home: AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainhome)
        val toolbar1=findViewById<MaterialToolbar>(R.id.toolbar)
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        //getSupportActionBar()?.hide();
        //setSupportActionBar(toolbar1);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val frameLayout=findViewById<FrameLayout>(R.id.main_framelayout)
        val drawer=findViewById<DrawerLayout>(R.id.drawerlayout)
        val navview=findViewById<NavigationView>(R.id.navigation)
        toggle= ActionBarDrawerToggle(this,drawer,toolbar1,R.string.open,R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navview.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home-> Toast.makeText(applicationContext,"clicked Home",Toast.LENGTH_SHORT).show()
                R.id.Setting->Toast.makeText(applicationContext,"clicked settings",Toast.LENGTH_SHORT).show()
                R.id.blah->Toast.makeText(applicationContext,"clicked blah",Toast.LENGTH_SHORT).show()
                R.id.account->Toast.makeText(applicationContext,"clicked account",Toast.LENGTH_SHORT).show()
                R.id.signout->Toast.makeText(applicationContext,"clicked signout",Toast.LENGTH_SHORT).show()

            }
            true
        }
        layoutManager= LinearLayoutManager(this)
        var recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager= layoutManager
        adapter= RecyclerAdapter()
        recyclerView.adapter= adapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}