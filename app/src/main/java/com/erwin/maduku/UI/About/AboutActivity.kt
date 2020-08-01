package com.erwin.maduku.UI.About

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erwin.maduku.Data.Data
import com.erwin.maduku.Data.Model
import com.erwin.maduku.R
import com.erwin.maduku.UI.Home.AdapterActivity
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        fab.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282284363365"))
            if (intent.resolveActivity(packageManager)!=null){
                startActivity(intent)
            }

        }


    }
}
