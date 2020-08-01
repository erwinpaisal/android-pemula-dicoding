package com.erwin.maduku.Data

import com.erwin.maduku.R

object Data {
    private val namaMadu = arrayOf(
        "Madu Sarang Melifera 250gram",
        "Madu Sarang Melifera 500gram",
        "Madu Sarang Randu 200gram",
        "Madu Sarang Hutan Riau 200gram",
        "Madu Sarang Hutan Kemlangi 250gram",
        "Madu Sarang Hutan Borneo 1Kg",
        "Madu Sarang Hutan Kalimantan 1Kg",
        "Madu Asli dari Hutan Baduy. Botol Kaca 600ml",
        "Madu Hitam Asli. Botol Plastik 300ml",
        "Madu Nectar 5 botol 650ml"
    )

    private val hargaMadu = intArrayOf(
        70000,
        250000,
        50000,
        125000,
        120000,
        273000,
        269000,
        97500,
        60000,
        100000
    )

    private val photoMadu = intArrayOf(
        R.drawable.melifera,
        R.drawable.melifera500,
        R.drawable.sarangrandu200,
        R.drawable.maduriau,
        R.drawable.maduhutankemlangi,
        R.drawable.maduhutanborneo,
        R.drawable.hutankalimantan,
        R.drawable.madubotol1,
        R.drawable.madubotol2,
        R.drawable.madubotol3
    )

    val listData: ArrayList<Model>
        get() {
            val list = arrayListOf<Model>()
            for (position in namaMadu.indices) {
                val madu = Model()
                madu.nama = namaMadu[position]
                madu.harga = hargaMadu[position]
                madu.photo = photoMadu[position]
                list.add(madu)
            }
            return list
        }
}