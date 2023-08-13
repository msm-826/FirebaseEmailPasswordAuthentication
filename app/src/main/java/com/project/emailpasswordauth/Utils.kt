package com.project.emailpasswordauth

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

class Utils {
    companion object {
        fun logError(e: Exception) = Log.e("firebase_tag", e.stackTraceToString())

        fun showMessage(
            context: Context,
            message: String?
        ) = makeText(context, message, LENGTH_LONG).show()
    }
}