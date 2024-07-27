package com.farimarwat.grizzly.crashmonitor

import android.content.Context
import android.content.Intent
import com.farimarwat.grizzly.GrizzlyConstants.EXTRA_MESSAGE
import com.farimarwat.grizzly.GrizzlyConstants.EXTRA_TITLE
import com.farimarwat.grizzly.ReportActivity
import com.google.firebase.crashlytics.FirebaseCrashlytics
import java.lang.Thread.UncaughtExceptionHandler
import kotlin.system.exitProcess

interface CustomExceptionHandler : UncaughtExceptionHandler {
    val context: Context
    val mFirebaseCrashlytics: FirebaseCrashlytics?
    val title: String
    val msg: String
}