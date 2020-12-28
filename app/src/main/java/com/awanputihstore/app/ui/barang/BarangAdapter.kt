package com.awanputihstore.app.ui.barang

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.awanputihstore.app.R
import com.awanputihstore.app.data.model.Barang
import com.awanputihstore.app.databinding.ItemBarangBinding
import com.awanputihstore.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class BarangAdapter(val context: Context) : BaseAdapter<Barang>(R.layout.item_barang) {
    override fun onBind(binding: ViewDataBinding?, data: Barang) {
        val mBinding = binding as ItemBarangBinding
        Glide.with(context).load(data.gambar).into(mBinding.itemGambar)
    }

    override fun onClick(binding: ViewDataBinding?, data: Barang) {
        val intent = Intent(context, BarangActivity::class.java)
        intent.putExtra(BarangActivity.OPEN_BARANG, data)
        context.startActivity(intent)
    }
}