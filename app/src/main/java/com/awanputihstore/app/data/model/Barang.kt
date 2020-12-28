package com.awanputihstore.app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 data class Barang (
     val nama_barang: String = "",
     val warna: String = "",
     val gambar: String = "",
     val harga: String = "",
     val ukuran: String = "",
     val stok: String = ""

 ) : Parcelable
