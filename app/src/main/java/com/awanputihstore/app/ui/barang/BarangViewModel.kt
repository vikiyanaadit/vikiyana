package com.awanputihstore.app.ui.barang

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awanputihstore.app.data.model.ActionState
import com.awanputihstore.app.data.model.Barang
import com.awanputihstore.app.data.repository.BarangRepository
import kotlinx.coroutines.launch

class BarangViewModel : ViewModel() {
    private val repo: BarangRepository by lazy { BarangRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Barang>>()
    val detailResp = MutableLiveData<Barang>()
    val searchResp = MutableLiveData<List<Barang>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listBarang() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listBarang()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailBarang(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailBarang(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }

    }

    fun searchBarang(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchBarang(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}