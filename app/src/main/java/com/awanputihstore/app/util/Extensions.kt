package com.awanputihstore.app.util

import android.content.SharedPreferences
import com.google.gson.Gson


inline fun <reified T> SharedPreferences.getObject(key: String, defValue: T? = null): T? {
    val json = getString(key, null)
    val obj = Gson().fromJson(json, T::class.java)
    return if (obj == null){
        defValue
    } else {
        obj
    }
}

fun SharedPreferences.Editor.putObject(key: String, value: Any?): SharedPreferences.Editor{
    val json = Gson().toJson(value)
    putString(key, json)
    return this
}