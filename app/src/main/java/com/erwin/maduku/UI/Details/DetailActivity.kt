package com.erwin.maduku.UI.Details

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.erwin.maduku.R
import com.erwin.maduku.UI.About.AboutActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.fab

class DetailActivity : AppCompatActivity() {

    lateinit var photo: ImageView
    lateinit var nama: TextView
    lateinit var harga: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        photo = findViewById(R.id.poto_produk)
        nama = findViewById(R.id.nama_produk)
        harga = findViewById(R.id.harga_produk)
        button = findViewById(R.id.btnBeli)

        nama.text = intent.getStringExtra("nama")
        harga.text = intent.getIntExtra("harga", 0).toString()

        Glide.with(this)
            .load(intent.getIntExtra("photo", 0))
            .into(photo)

        fab.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282284363365"))
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            button.setOnClickListener {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282284363365"))
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }
        }
    }
        override fun onSupportNavigateUp(): Boolean {
            finish()
            return false
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            var menuInflate = menuInflater
            menuInflate.inflate(R.menu.menu_home, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            intent = Intent(applicationContext, AboutActivity::class.java)
            when (item.getItemId()) {
                R.id.action_about -> {
                    startActivity(intent)
                }
            }
            return super.onOptionsItemSelected(item)
        }
}
