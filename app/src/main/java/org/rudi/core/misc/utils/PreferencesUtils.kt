package org.rudi.core.misc.utils

import android.content.Context
import android.content.SharedPreferences

class PreferencesUtils(
    context: Context,
    preferencesName: String
) {

    private val sharedPreferences: SharedPreferences = context
        .getSharedPreferences(preferencesName, Context.MODE_PRIVATE)!!

    fun putInt(keyName: String, value: Int) {
        sharedPreferences.apply {
            edit()
                .putInt(keyName, value)
                .apply()
        }
    }

    fun putString(keyName: String, value: String) {
        sharedPreferences.apply {
            edit()
                .putString(keyName, value)
                .apply()
        }
    }

    fun putFloat(keyName: String, value: Float) {
        sharedPreferences.apply {
            edit()
                .putFloat(keyName, value)
                .apply()
        }
    }

    fun putBoolean(keyName: String, value: Boolean) {
        sharedPreferences.apply {
            edit()
                .putBoolean(keyName, value)
                .apply()
        }
    }

    fun getInt(keyName: String): Int{
        return sharedPreferences.getInt(keyName, 0)
    }

    fun getString(keyName: String): String {
        return sharedPreferences.getString(keyName, "")?:""
    }

    fun getFloat(keyName: String): Float{
        return sharedPreferences.getFloat(keyName, 0f)
    }

    fun getBoolean(keyName: String): Boolean{
        return sharedPreferences.getBoolean(keyName, false)
    }
}