package com.awanputihstore.app.ui.barang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awanputihstore.app.R

class BarangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)
    }

    companion object{
        const val OPEN_BARANG = "open_barang"
    }
}

