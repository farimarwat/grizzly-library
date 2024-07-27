package com.farimarwat.grizzly.crashmonitor

import android.content.Context
import com.google.firebase.crashlytics.FirebaseCrashlytics

internal class CrashMonitorBuilder(private val context: Context) {
    private var mTitle: String = "Application Error"
    private var mMessage: String = "An unexpected error occurred. Please restart the app."
    private var mFirebaseCrashlytics: FirebaseCrashlytics? = null

    fun withTitle(title: String): CrashMonitorBuilder {
        this.mTitle = title
        return this
    }

    fun withMessage(message: String): CrashMonitorBuilder {
        this.mMessage = message
        return this
    }

    fun withFirebaseCrashlytics(firebaseCrashlytics: FirebaseCrashlytics?): CrashMonitorBuilder {
        this.mFirebaseCrashlytics = firebaseCrashlytics
        return this
    }

    fun build(): CrashMonitor = CrashMonitorImpl(
        mContext = context,
        mCrashLytics = mFirebaseCrashlytics,
        mTitle = mTitle,
        mMessage = mMessage
    )
}