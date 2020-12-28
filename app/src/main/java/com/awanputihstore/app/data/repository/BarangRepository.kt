package com.awanputihstore.app.data.repository

import android.app.DownloadManager
import com.awanputihstore.app.data.model.ActionState
import com.awanputihstore.app.data.model.Barang
import com.awanputihstore.app.data.remote.BarangService
import com.awanputihstore.app.data.remote.RetrofitApi
import retrofit2.await

class BarangRepository {
    private val barangService: BarangService by lazy { RetrofitApi.barangService() }

    suspend fun listBarang() : ActionState<List<Barang>> {
        return try {
            val list = barangService.listBarang().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailBarang(url: String) : ActionState<Barang> {
        return try {
            val list = barangService.detailBarang(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchBarang(query: String) : ActionState<List<Barang>> {
        return try {
            val list = barangService.searchBarang(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}