package com.awanputihstore.app.ui.auth

import android.content.Context
import com.awanputihstore.app.data.model.ActionState
import com.awanputihstore.app.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object AwanputihAuth {

    fun logout(context: Context, callback: ((ActionState<Boolean>) -> Unit)? = null) {
        val repo = AuthRepository(context)
        CoroutineScope(Dispatchers.IO).launch {
            val reps = repo.logout()
            withContext(Dispatchers.Main) {
                if(callback!= null) callback.invoke(reps)
            }
        }
    }
}