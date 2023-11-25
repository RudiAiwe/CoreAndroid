package org.rudi.core.data

import android.content.Context
import android.content.SharedPreferences

open class CustomPreferences(
    val context: Context,
    val name: String
) {
    private val sharedPreferences: SharedPreferences = context
        .getSharedPreferences(name, Context.MODE_PRIVATE)!!

    protected fun putInt(keyName: String, value: Int) {
        sharedPreferences.apply {
            edit()
                .putInt(keyName, value)
                .apply()
        }
    }

    protected fun putString(keyName: String, value: String) {
        sharedPreferences.apply {
            edit()
                .putString(keyName, value)
                .apply()
        }
    }

    protected fun putFloat(keyName: String, value: Float) {
        sharedPreferences.apply {
            edit()
                .putFloat(keyName, value)
                .apply()
        }
    }

    protected fun putBoolean(keyName: String, value: Boolean) {
        sharedPreferences.apply {
            edit()
                .putBoolean(keyName, value)
                .apply()
        }
    }

    protected fun getInt(keyName: String): Int{
        return sharedPreferences.getInt(keyName, 0)
    }

    protected fun getString(keyName: String): String {
        return sharedPreferences.getString(keyName, "")?:""
    }

    protected fun getFloat(keyName: String): Float{
        return sharedPreferences.getFloat(keyName, 0f)
    }

    protected fun getBoolean(keyName: String): Boolean{
        return sharedPreferences.getBoolean(keyName, false)
    }
}