package com.awanputihstore.app.data.remote

import com.awanputihstore.app.data.model.BarangList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BarangService {
    @GET("/native/awanputihstore")
    fun listBarang() : Call<BarangList>

    @GET("/native/awanputihstore")
    fun detailBarang(@Query("url")url: String) :Call<BarangList>

    @GET("/native/awanputihstore")
    fun searchBarang(@Query("q") query: String) :Call<BarangList>
}