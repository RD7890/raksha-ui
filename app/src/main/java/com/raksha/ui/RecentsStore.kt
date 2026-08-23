package com.raksha.ui

import android.content.Context
import android.content.SharedPreferences

object RecentsStore {

    private const val PREFS = "recents"
    private const val KEY = "launch_history"
    private const val MAX = 8

    fun record(context: Context, packageName: String) {
        val prefs = prefs(context)
        val list = history(prefs).toMutableList()
        list.remove(packageName)
        list.add(0, packageName)
        while (list.size > MAX) list.removeAt(list.size - 1)
        prefs.edit().putString(KEY, list.joinToString(",")).apply()
    }

    fun history(context: Context): List<String> = history(prefs(context))

    fun remove(context: Context, packageName: String) {
        val prefs = prefs(context)
        val list = history(prefs).toMutableList()
        list.remove(packageName)
        prefs.edit().putString(KEY, list.joinToString(",")).apply()
    }

    private fun prefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

    private fun history(prefs: SharedPreferences): List<String> =
        prefs.getString(KEY, null)?.split(',')?.filter { it.isNotBlank() } ?: emptyList()
}
