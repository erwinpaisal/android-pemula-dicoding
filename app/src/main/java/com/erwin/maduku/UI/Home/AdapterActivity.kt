package com.erwin.maduku.UI.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.erwin.maduku.Data.Model
import com.erwin.maduku.R
import com.erwin.maduku.UI.Details.DetailActivity

class AdapterActivity (val listProduk : ArrayList<Model>) : RecyclerView.Adapter<AdapterActivity.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val (nama, harga, photo) = listProduk[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.ivPhoto)

        holder.tvNama.text = nama
        holder.tvHarga.text = harga.toString()

        holder.cvProduct.setOnClickListener {
            var intent : Intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("harga", harga)
            intent.putExtra("photo", photo)
            holder.itemView.context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama : TextView = itemView.findViewById(R.id.nama_madu)
        var tvHarga : TextView = itemView.findViewById(R.id.harga_madu)
        var ivPhoto : ImageView = itemView.findViewById(R.id.photo_produk)
        var cvProduct : CardView = itemView.findViewById(R.id.cvmadu)
    }
}