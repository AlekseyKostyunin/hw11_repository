package com.alekseykostyunin.hw11_repository

import android.content.Context

private const val PREFERENCE_NAME = "preference_name"
private const val SHARED_PREFS_KEY = "shared_pref_key"

class Repository {

    private var localVariable: String? = null

    fun getText(context: Context): String {
        return when {
            getDataFromLocalVariable() != null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference(context) != null -> getDataFromSharedPreference(context)!!
            else -> ""
        }
    }

    private fun getDataFromSharedPreference(context: Context): String? {
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return pref.getString(SHARED_PREFS_KEY, null)
    }

    private fun getDataFromLocalVariable(): String? {
        return localVariable
    }

    fun clearText(context: Context) {
        localVariable = null
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pref.edit().remove(SHARED_PREFS_KEY).apply()
    }

    fun saveText(context: Context, text: String) {
        localVariable = text
        val pref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        pref.edit().putString(SHARED_PREFS_KEY, text).apply()
    }

}