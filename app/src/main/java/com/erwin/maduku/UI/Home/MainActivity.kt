package com.erwin.maduku.UI.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erwin.maduku.Data.Data
import com.erwin.maduku.Data.Model
import com.erwin.maduku.R
import com.erwin.maduku.UI.About.AboutActivity

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Model> = arrayListOf()
        lateinit var rvProduct : RecyclerView
        lateinit var svProduct : NestedScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Maduku"
        supportActionBar?.elevation = 0F

        svProduct = findViewById(R.id.scrollview)
        svProduct.setOnScrollChangeListener {v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScroolY: Int ->
            if (scrollY > 0) {
                supportActionBar?.elevation = 3F
            }else{
                supportActionBar?.elevation = 0F
            }
        }

        rvProduct = findViewById(R.id.rvProduct)
        rvProduct.setHasFixedSize(true)

        list.addAll(Data.listData)

        rvProduct.layoutManager  = LinearLayoutManager(this)
        val adapter = AdapterActivity(list)
        rvProduct.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflate = menuInflater
        menuInflate.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        intent = Intent(applicationContext, AboutActivity::class.java)
        when(item.getItemId()){
            R.id.action_about -> {
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}
